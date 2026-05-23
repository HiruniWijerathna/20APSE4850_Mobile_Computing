import socket

# Create socket
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to server
client.connect(("localhost", 5000))

# Chat loop
while True:

    # Input message
    message = input("You: ")

    # Send message
    client.send(message.encode())

    # Client exit condition
    if message.lower() == "exit":
        break

    # Receive response
    response = client.recv(1024).decode()

    print("Server:", response)

    # Server exit condition
    if response.lower() == "exit":
        break

# Close socket
client.close()
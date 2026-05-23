import socket

# Create socket
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind IP and port
server.bind(("localhost", 5000))

# Listen for connections
server.listen()

print("Server is waiting for connection...")

# Accept client connection
client_socket, addr = server.accept()

print("Client connected on", addr)

# Chat loop
while True:

    # Receive message from client
    message = client_socket.recv(1024).decode()

    # Check disconnect
    if message.lower() == "exit":
        print("Client disconnected")
        break

    # Print client message
    print("Client:", message)

    # Send reply
    reply = input("Server: ")

    client_socket.send(reply.encode())

    # Server exit condition
    if reply.lower() == "exit":
        break

# Close sockets
client_socket.close()
server.close()
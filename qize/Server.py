import socket

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(('127.0.0.1', 5000))
server_socket.listen(1)
print("Server started on port 5000, waiting for connections...")

conn, addr = server_socket.accept()
print("Client connected")

while True:
    
    data = conn.recv(1024).decode()
    print(f"Client: {data}")
    
    if data.lower() == "exit":
        conn.close()
        break
    

   
    message = input("Server: ")
    conn.send(message.encode())

    

conn.close()
server_socket.close()
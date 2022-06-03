import socket
from time import *
import sys
import admin

print("Successfully attached process")

ip = sys.argv[1]
Port = sys.argv[2]

def createListener(port):
        print("Now scanning IP address " + ip + " on open network port " + port)
        sleep(2);
        srvSock = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.IPPROTO_IP)
        srvSock.bind((ip, int(port)))
        srvSock.ioctl(socket.SIO_RCVALL, socket.RCVALL_ON)
        while True:
            raw_data, addr = srvSock.recvfrom(65536)
            print('data: ' , raw_data)

#checks for admin privileges
if not admin.isUserAdmin():
    admin.runAsAdmin()
    print("Requesting Admin privileges")

if admin.isUserAdmin():
    print("Successfully elevated")
    createListener(Port)
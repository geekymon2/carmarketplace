#!bin/bash
# NOTE: run this within the pod to perform various troubleshooting e.g. networks and connectivity testing etc.
# E.G. Run telnet connection tests to confirm host/port connectivity. telnet host port
# MySQL DB: telnet db 3306


apt update && apt install -y net-tools && apt install -y curl && apt install -y dnsutils && apt install -y iputils-ping && apt install -y telnet


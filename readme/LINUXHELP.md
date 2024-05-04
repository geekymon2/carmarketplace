# Linux Helper Commands

### Check Port Usage
- $sudo lsof -i -P -n | grep LISTEN

### SystemD Service Commands
- systemctl status {service-name}
- systemctl list-units --type=service
- systemctl stop {service-name}
- systemctl start {service-name}


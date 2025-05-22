#!/bin/bash

sudo cp -f /home/ubuntu/app/notice.service /etc/systemd/system/notice.service
sudo systemctl daemon-reload
sudo systemctl start notice.service
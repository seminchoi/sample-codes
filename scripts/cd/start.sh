#!/bin/bash

sudo cp -f /home/ubuntu/app/reg.service /etc/systemd/system/reg.service
sudo systemctl daemon-reload
sudo systemctl start reg.service
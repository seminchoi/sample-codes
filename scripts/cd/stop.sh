#!/bin/bash

sudo cp -f /home/ubuntu/app/notice.service /etc/systemd/system/notice.service
sudo systemctl stop notice.service
#!/bin/bash

sudo cp -f /home/ubuntu/app/reg.service /etc/systemd/system/reg.service
sudo systemctl stop reg.service
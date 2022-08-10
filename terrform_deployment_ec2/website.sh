sudo su 
yum update -y
yum install -y httpd
cd var/www/html
wget https://github.com/edmanfierthe/website/archive/main.zip
unzip main.zip
cp -r website-main/* /var/www/html
rm -rf website-main main.zip
systemctl enable httpd
systemctl start httpd
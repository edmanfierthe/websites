



resource "aws_instance" "me" {
  ami                    = var.ami
  instance_type          = "t2.micro"
  subnet_id              = aws_subnet.private_subnet.id
  vpc_security_group_ids = [aws_security_group.ec2.id]
  user_data              = file("website.sh")
  key_name               = "project_keypair"
  depends_on = [
    aws_subnet.private_subnet
  ]
  tags = {
    Name = "animated"
  }
}
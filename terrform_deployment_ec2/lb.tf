# Load Balancer for our public subnet

resource "aws_lb" "project" {
  name               = "lb"
  internal           = false
  load_balancer_type = "application"
  security_groups    = [aws_security_group.default.id]
  subnets            = aws_subnet.public_subnet.*.id
  enable_deletion_protection = false
  

  tags = {
    Environment = "${var.Environment}"
  }
}

resource "aws_lb_target_group" "test" {
  name     = "tf-example-lb-tg"
  port     = 80
  protocol = "HTTP"
  vpc_id   = aws_vpc.vpc.id
  target_type = "ip"
  
  health_check {
    healthy_threshold   = "3"
    interval            = "30"
    protocol            = "HTTP"
    matcher             = "200"
    timeout             = "3"
    path                = "/"
    unhealthy_threshold = "2"
  }
}

resource "aws_lb_listener" "front_end" {
  load_balancer_arn = aws_lb.project.id
  port              = 80
  protocol          = "HTTP"
  

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.test.id
  }
}

resource "aws_elb_attachment" "attach_ec2" {
  depends_on = [
    aws_lb.project
  ]
  elb      = aws_lb.project.arn
  instance = aws_instance.me.id
}

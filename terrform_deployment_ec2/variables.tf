variable "Environment" {
    default = "personal"
}

variable "vpc_cidr" {
    description = "The CIDR block for the vpc"
    default = "10.0.0.0/16"
}

variable "public_cidr_block" {
    description = "The CIDR block for the public subnet"
    default = ["10.0.1.0/24", "10.0.2.0/24"]
}

variable "availability_zones" {
    type        = list(string)
    description = "The azs for the subnets"
    default = ["us-east-2a", "us-east-2b"]

}

variable "private_cidr_block" {
    description = "The CIDR block for the private subnet"
    default = "10.0.3.0/24"
}

variable "ecs_task_execution_role_name" {
  description = "ECS task execution role name"
  default = "myEcsTaskExecutionRole"
}

variable "aws_region" {
    default = "us-east-2"
}
variable "ami" {
    description = "The AMI ID for the instance"
    type = string
    default = "ami-02d1e544b84bf7502"
}




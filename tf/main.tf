terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~>5.0"
    }
  }
}

provider "aws" {
  region     = "eu-west-3"
}

#resource "aws_security_group" "MK-ODW-2-sg" {
#  name        = "MK-ODW-2-sg"
#  description = "allow 8080 and SSH inbound traffic"
#  ingress {
#    from_port   = 8080
#    to_port     = 8080
#    protocol    = "tcp"
#    cidr_blocks = ["0.0.0.0/0"]
#  }
#  ingress {
#    from_port   = 22
#    to_port     = 22
#    protocol    = "tcp"
#    cidr_blocks = ["0.0.0.0/0"]
#  }
#  egress {
#    from_port   = 0
#    to_port     = 0
#    protocol    = "-1"
#    cidr_blocks = ["0.0.0.0/0"]
#  }
#  tags = {
#    Name = "MK-ODW-2-sg"
#  }
#}

resource "aws_instance" "MK-ODW-2" {
  ami             = "ami-05b5a865c3579bbc4"
  instance_type   = "t3.micro"
#  security_groups = [aws_security_group.MK-ODW-2-sg.name]
  security_groups = ["MK-ODW-2-sg"]
  #key_name        = aws_key_pair.MK-ODW-15-key-pair.key_name
  user_data       = file("starter-script.sh")
  tags = {
    Name = "MK-ODW-2-circleci-deployment"
  }
}

output "ec2_public_ip" {
  value = aws_instance.MK-ODW-2.public_ip
}
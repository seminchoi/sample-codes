data "aws_s3_bucket" "cicd" {
  bucket = "ec2-cicd-bucket-20250522"
}

data "aws_vpc" "msa_vpc" {
  id = var.vpc_id
}

data "aws_subnet" "public_subnets" {
  count = length(var.public_subnet_ids)
  id = var.public_subnet_ids[count.index]
}

data "aws_subnet" "private_subnets" {
  count = length(var.private_subnet_ids)
  id = var.private_subnet_ids[count.index]
}
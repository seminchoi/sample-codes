module "eks_cicd" {
  source        = "./eks-cicd"  # 모듈 경로 또는 원격 주소
  vpc_id        = aws_vpc.msa_vpc.id
  public_subnet_ids = [ for subnet in aws_subnet.public_subnets: subnet.id ]
  private_subnet_ids = [ for subnet in aws_subnet.private_subnets: subnet.id ]
}
locals {
  default_subnet_id = tolist(data.aws_subnets.this.ids)[0]
}
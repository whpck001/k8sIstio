#!/bin/bash
echo "开始创建镜像......................................................"

    echo "  步骤1: 制作docker镜像"
        mv target/*jar ci/build/
        cd ci/build
        docker build -t $1 .

     echo "  步骤2: 上传镜像"
        docker tag $1 internalacr.azurecr.cn/$1
        docker push internalacr.azurecr.cn/$1
        docker rmi $1
        docker rmi internalacr.azurecr.cn/$1

echo "创建镜像结束......................................................"

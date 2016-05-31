# Simple Describe
基于Mahout的图书推荐系统（web实现）
# 系统环境
* MySQL-5.5
* Maven-4.0
* Mahout-0.8
* JDK-1.8
* Tomcat-8.0
* Eclipse
# 系统框架
![image](https://github.com/acumen1005/Recommendation/blob/master/systemImage.png)
# 推荐算法伪代码
for（用户 u 尚未表达偏好的）每个物品i    
   for（用户 u 表达的偏好）每个物品j            
     计算 i 和 j 之间的相似度s           
     按权重为 s 将 u 对 j 偏好并入平均值   
 return  值最高的物品（按加权平均排序）

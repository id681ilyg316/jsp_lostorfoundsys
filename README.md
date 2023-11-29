## 本项目实现的最终作用是基于JSP在线失物招领管理平台
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 寻物信息管理
 - 招领信息管理
 - 管理员登录
### 第2个角色为用户角色，实现了如下功能：
 - 寻物处
 - 招领物品
 - 查看首页
## 数据库设计如下：
# 数据库设计文档

**数据库名：** lostorfoundsys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [guanliyuan](#guanliyuan) |  |
| [xiaoxi](#xiaoxi) |  |

**表名：** <a id="guanliyuan">guanliyuan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | zhanghao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 账号  |
|  3   | mima |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="xiaoxi">xiaoxi</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | leixing |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | zhuti |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | wupin |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | neirong |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  6   | lianxiren |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  8   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  9   | imagesName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**运行不出来可以微信 javape 我的公众号：源码码头**

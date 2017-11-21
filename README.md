
#  1.项目简介：
## 一款发布信息与查询信息的app，目前主要侧重人群为大学生。  
` 
  聪明人善于抓住机会，智慧者勇于创造机会。
`
 
 &emsp;&emsp;这句话相信大家都听说过，聪明的人与智者这两类人代表了两种不同的态度，是被动的接受还是主动的获取？当然是选择后者。在当下信息化的时代这一点显得尤为重要，信息中包含着许许多多机遇、挑战，如何能够高效的去获取大量的信息从而抓住机遇成为我们常常苦恼的问题。
  
 
 &emsp;&emsp;你是否在某天的课后突然注意到品学楼下的展板上贴出上周的一个学长学姐办的交流会，然后为错失这次交流机会而懊恼万分；你是否在某天去宾诺咖啡休息时意外发现此刻一位千人计划的学者正在介绍科研领域前言的一些内容而倍感欣喜？......
 
 &emsp;&emsp;种种错失信息而导致错失机会的例子不断发生在我们和同学的身边，能否让这些信息有一个统一的发布与查询的平台，方便大家发布与获取信息成为一个急需解决的问题。在这个信息化、智能化的时代，我们可以利用信息流动迅速的互联网来帮助我们达到这个目的。试想一下，只需一款app即可随时随地查询校内的众多活动、比赛、讲座等信息，大大提高了我们获取信息的效率，再也不用每天关注众多qq群与微信号，时刻注意是否有自己想参与的活动与讲座，再也不用每天穿梭于品学楼、立人楼去一张一张海报的搜索，大大缩短了一些不必要的时间花费。不仅方便了我们每个人，而且这种高效的活动信息管理对于推动智慧校园的发展也有重大意义。
  
# 2.详细介绍：
## 2.1：app的使用人群

  &emsp;&emsp; xxx产品的使用者分为三类人群，一类是以游客形式使用app的获取信息的人群；一类是以发布活动为主的提供信息的主办方；一类是管理员。
&emsp;&emsp;游客（主要是大学生）可以在qpp中找到自己希望获取的信息。

&emsp;&emsp;主办方可以在app中发布自己社团（/工作室/团体....）要举办的活动。
&emsp;&emsp;管理员要对主办方的身份进行确认，只有通过认证的主办方才可以发布信息，这一点保证了信息的准确性。
 ## 2.2：功能介绍
  游客可以通过活动名称或者主办方名称搜索相关活动，也可以通过活动的分类进行分类查询。

  主办方可以发布活动，查看自己发布的所有活动，修改已发布的活动信息。

  管理员可以对主办方的身份进行认证，同时可以管理活动的分类信息。
## 2.3：项目原型部分截图展示
### 2.3.1--------app主页面（搜索活动），活动详细信息页面
  ![image](https://github.com/BirdFlying123/infocollect/raw/v1.0/image/1.png)
  ![image](https://github.com/BirdFlying123/infocollect/raw/v1.0/image/2.png)
### 2.3.2--------发布活动页面
  ![image](https://github.com/BirdFlying123/infocollect/raw/v1.0/image/3.png)
  
# 3.开发介绍：
## 3.1最终产品：
   &emsp;&emsp;最终产品为app和网页。app供游客和主办方使用，用来发布活动于查询活动。网页供管理员使用来进行主办方身份的验证。
## 3.2开发技术：
   &emsp;&emsp;后台：采用spring、springmvc、mybatis框架进行开发，maven进行包管理，最终将项目部署到阿里云服务器。

  &emsp;&emsp; 前端：html、css、开发，管理员登录网址：http://120.78.189.95/
  
  
  &emsp;&emsp;安卓：Android studio开发，安卓部分的代码链接：https://github.com/taoz27/IdeaApp

# 4.gif图片
## 4.1游客
### 4.1.1搜索活动以及查看其详细信息
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/search.gif)
## 4.2主办方
### 4.2.1注册、登录、退出
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/登录.gif)
### 4.2.2修改信息
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/修改个人信息.gif)
### 4.2.3未认证发布活动（失败，不能发布）
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/未认证发布.gif)
### 4.2.4管理员认证
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/通过验证.gif)
### 4.2.5认证后发布活动，查看我的空间
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/已认证发布.gif)
### 4.2.6修改删除活动
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/修改删除活动.gif)
## 4.3管理员
### 4.3.1通过验证
![image](https://github.com/taoz27/IdeaApp/raw/master/gifs/通过验证.gif)







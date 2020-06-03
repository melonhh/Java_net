# Java_net
计算机网络、Java网络编程和AIO、NIO

## 计算机网络
### 网络与互联网
* 网络把许多计算机连接在一起
* 互联网把许多网络连接在一起

#### 互联网的边沿部分和核心部分
* 边沿部分就是连在网上的所有主机（端系统）
* 核心部分网络和路由器
    * 为网络中的主机提供连通性
    * 网络核心中起特殊作用的是路由器（实现分组交换---这是网络核心最重要的功能）

#### 两种通信方式
* 客户服务器方式：C/S
    * 客户和服务器都是指通信中所涉及到的两个应用进程
* 对等方式P2P
    * 两个通信主机并不区分哪一个是请求方还是服务提供方
    
#### 电路交换和分组交换
电路交换：
* 电路交换是面向连接的
* 电路交换的三个阶段：
    * 建立连接（打电话，拨号，对方摘机建立连接）
    * 通信
    * 释放连接
* 电路交换特点
    * 在通话的全过程中，两个用户始终占用端到端的通信资源  
    
分组交换：
* 分组交换采用报文切分和存储转发技术
* 分组交换的优点：
    * 高效：动态分配传输带宽，对通信链路是逐段占用
    * 迅速：不必先建立连接
* 分组带来的问题：
    * 分组在各结点存储转发时需要排队，造成一定时延
    * 分组必须携带首部，造成一定开销
    
#### 计算机网络的定义
* 计算机网络是一些互相连接的，自治的计算机的集合
* 因特网是网络的网络

不同范围的网络：
* WAN：广域网
* LAN：局域网
* MAN：城域网

#### 计算机网路的性能指标
1. 速率rate
2. 带宽bandwidth：数字通道的所能传送的最高速率
3. 吞吐量throughput：表示在单位时间内通过某个网络的数据量
4. 时延delay：一个数据/报文从网络的一端到另一端的时间
    * 发送时延（传输时延）
    * 传播时延
    * 处理时延
    * 排队时延
    * 对于高速网络链路，我们提高的是发送速率，而不是数据链路上的传播速率
5. 时延带宽积=传播时延*带宽

### 物理层
#### 物理层的基本概念
物理层考虑的是怎样才能在连接各种计算机的传输媒体上传输数据比特流，而不是指具体的传输媒体  

物理层的任务是确定域传输谜题接口的一些特征：
* 机械特性  指明接口所用接线器的形状和尺寸等物理特性
* 电气特性  指明电压范围和表示
* 功能特性  指明何种电平表示何种意义
* 过程特性  指明对于不同功能的各种可能事件的出现顺序

#### 数字通信
* 基本术语：
    * 消息message
    * 数据data：运送消息的实体
    * 信号signal：数据的电气或电磁的表现
    * 模拟的：代表消息参数的取值是连续的
    * 数字的：代表消息参数的取值是离散的
    * 码元  
    
信道概念
    * 将数据从一个位置传递到另一个位置需要某种形式的路径或媒体

信道复用技术
    * 频分复用
    * 时分复用
    * 统计时分复用
    * 码分复用

### 数据链路层
* 使用点对点信道的数据链路层
* 点对点协议PPP
* 使用广播信道的数据链路层
* 扩展的以太网
* 高速以太网  

数据链路层使用的信道主要有：
* 点对点信道
* 广播信道  

使用点对点信道的数据链路层  
* 链路：一条无源的点到点的物理线路段，中间没有任何其他的交换节点
* 数据链路：处理物理线路外，还必须有通信协议来控制这些数据的传输  

数据链路层有多种协议，存在三个基本问题：
1. 封装成帧
2. 透明传输
3. 差错检验  

封装成帧
* 封装成帧就是在一段数据的前后分别添加首部和尾部，然后构成一个帧
* SOH（start of header）
* EOT（end of transmission）  

透明传输
* 使数据中出现的控制字符在接收端不被解释为控制字符
* 字节填充
    * 在控制字符前加入转义字符
* 字符填充  

差错检测
* 在传输过程中可能会产生比特差错：1可能变成0，0可能变成1
* 在数据链路层传送的帧中，广泛使用了循环冗余检测CRC的检错技术
* 在发送端，先把数据划分为组，假定每组K个比特
* 假设待传送的一组数据M=101001,k=6。我们在M的后面再添加供差错检测用的n位冗余码一起发送  

冗余码的计算
* 用二进制的模2运算进行2^n乘M的运算，相当于再M后添加n个0
* 得到的（k+n）位的数除以事先选定好的长度位（n+1）位的除数p，得出商是Q，而余数是R（n位）（其实并不是除，而是按位异或运算）
* 冗余码称为帧检验序列FCS  

注意  
* 仅使用循环冗余检测CRC差错检测技术只能做到“无差错接受”
* 无差错接受：这些接受的帧能以非常接近于1的概率再传输过程中没有产生差错
* 传输差错：比特差错、帧丢失、帧重复、帧失序
* 要做到“可靠传输”，还必须加上编号，确认和重传机制
* 现在因特网采用区别对待的方法：
    * 通信质量好的有线传输链路不使用确认和重传机制
    * 无线传输链路使用确认和重传机制
    
#### 点对点协议PPP
特点  
* 用户连接ISP一般使用PPP协议  

PPP协议的组成
* 一个将IP数据报封装到串行链路的方法
* 一个链路控制协议LCP
* 一个网络控制协议NCP

PPP协议的帧格式
* PPP帧首部4个字段，尾部2个字段
* 标志字段F 7E
* 地址字段A FF
* 控制字段C 03
* 协议
    * 0x0021时，PPP帧的信息字段就是IP数据报
    * 0xC021时，LCP控制数据
    * 0x8021时，NCP控制数据
* 信息字段
* FCS
* F 7E

PPP透明传输问题  
* PPP异步传输（面向字符传输）：使用字符填充
    * 每一个0x7E字节 ---> 0x7D, 0x5E
    * 每一个0x7D字节 ---> 0x7D, 0x5D
* PPP同步传输（面向比特传输）：使用零比特填充
    * 只要发现5个连续1，则立即填入一个0
    
PPP协议的工作状态
* 用户拨号接入ISP，建立物理连接
* PC机向路由器发送一系列LCP分组进行参数配置（最大帧长，鉴别协议）
* 进行网络层配置，NCP给PC分配临时IP地址
* 通信完毕时，NCP释放网络层连接，收回分配出去的IP地址，LCP释放链路层连接，最后释放物理层连接


#### 使用广播信道的数据链路层
局域网的数据链路层
* 局域网的主要特点：网络为一个单位所拥有，且地理范围和站点数目均有限
* 局域网的优点：
    * 具有广播优点
    * 便于系统的扩展和逐渐地演变，设备的位置可灵活调整
    * 提高了系统的可靠性、可用性、生存性
* 局域网的拓扑：星型、总线型、环形网、树形网  

媒体共享技术
* 静态划分信道
    * 频分复用
    * 时分复用
    * 波分复用
    * 码分复用
* 动态媒体接入控制
    * 随机接入
    * 受控接入，如多点线路探询
    
适配器
* 适配器的重要功能：
    * 进行串行/并行转换
    * 对数据进行缓存
    * 实现以太网协议
* 计算机通过适配器和局域网进行通信
    

* 为了通信的简便，以太网采取了两种重要的措施
    * 无连接，不必先建立连接就可以直接发送数据
    * 以太网对发送的数据帧不进行编号，也不要求对方发回确认


以太网提供的服务
* 以太网不可靠的交付服务
* 当收到差错的数据帧时直接丢弃，其他啥也不做

以太网使用曼切斯特编码

载波监听多点接入/碰撞检测CSMA/CD
* 多点接入
    * 许多计算机以多点接入的方式连接在一根总线上
* 载波监听
    * 每个站在发送数据前先要检测一下总线上是否有其他计算机在发送数据
* 碰撞检测
    * 在计算机边发送数据变检测信道上的信号电压大小
    * 当几个站同时在总线上发送数据时，总线上的电压摆动值将会增大
    
传播时延对载波监听的影响
* 争用期：两个往返时延
* 经过争用期这段时间还没有检测到碰撞，才能肯定这次发送不会发生碰撞

二级制指数类型退避算法
* 确定基本退避时间，一般为争用期
* 定义重传次数k，k<=10
* 从[0,1,2,,,,2^k-1]中随机地取出一个数r，重传所需要地时延就是r倍地基本退避时间
* 当重传达16次仍不能成功，则丢弃该帧

以太网的信道利用率
* 一个帧的发送时间：T = [争用期] + [发送时间T0 = L(bit)/C(b/s)] + [半个争用期]
* 定义参数：a = 半个争用期/T0
* 理想状态下信道利用率： Smax = T0/（T0 + 半个争用期） = 1/（a+1）

以太网的MAC层
1. MAC层的硬件地址

适配器检查MAC地址
* 适配器从网络上每收到一个MAC帧就首先用硬件检查MAC帧中地MAC地址
    * 如果是发往本站地帧就收下
    * 否则就将此帧丢弃
* “发往本站的帧”包括：
    1. 单播帧
    2. 广播帧 一对全体ff:ff:ff:ff:ff:ff
    3. 多播帧

以太网的MAC帧格式
* 目的地址6
* 源地址6
* 类型2
* 数据（46~1500）：最小长度64字节-18字节首部和尾部
* FCS（字节）

MAC帧下物理层
* 为了达到比特同步，在传输媒体上实际传送的要比MAC帧还多8个字节
* 前七个同步码，用来迅速实现MAC帧的比特同步
* 后一个字节是帧开始定界符，表示后面就是MAC帧

#### 扩展局域网
1. 用集线器扩展局域网
    * 优点：
        * 使原来不同碰撞域的局域网上的计算机能够进行跨碰撞域通信
        * 扩大了局域网覆盖的地理范围
    * 缺点：
        * 碰撞域增大了，但总的吞吐量并未提高
        * 如果不同的碰撞域使用不同的数据率，那么就不能用集线器将他们连接起来
    
2. 使用网桥/交换机
    * 过滤通信量
    * 扩大物理范围
    * 提高可靠性
    * 可互连不同物理层，不同MAC子层、不同速率的局域网
    
3. 网桥/集线器的不同
    * 集线器在转发帧时，不对传输媒体进行检测
    * 网桥在转发帧之前必须执行CSMA/CD算法
    
4. 透明网桥
    * 目前使用最多的网桥是透明网桥
    * 透明指：局域网上的站点并不知道所发送的帧将经过哪几个网桥，因为网桥对各站来说是看不见的
    * 一种即插即用的设备
    * 使用生成树算法，避免产生转发的帧在网络中不断兜圈子
5. 网桥在转发表中登记以下三个信息
    * 地址
    * 接口
    * 进入网桥的时间
    
#### 多接口网桥---以太网交换机
* 以太网交换机的每个接口都直接与主机相连，并且一般都工作在全双工方式
* 交换机能同时连通许多对的接口，进行无碰撞地传输数据

独占传输媒体的带宽
* 交换机的最大优点是一个用户独占传输媒体的带宽

存储转发方式
* 进行差错检测
* 可进行线路速率匹配
* 数据处理时延大

虚拟局域网VLAN
* 是由一些居于网网段构成的与物理位置无关的逻辑组
    * 这些网络具有某些共同的需求
    * 每一个Vlan的帧都有一个明确的标识符，指明发送则个帧的工作站属于哪一个vlan
* 虚拟局域网其实只是局域网给用户提供的一种服务

### 网络层
* 网络层提供的两种服务
* 网际协议IP
* 划分子网和构造超网
* 网际控制报文协议ICMP
* 因特网的路由选择协议
* IPv6
* IP多播
* 虚拟专用网VPN和网络地址转换NAT


#### 计算机提供的两种服务
1. 虚电路服务
    * 虚电路是逻辑连接
        * 虚电路在分组交换网上的两个端点间的链路
        * 虚电路是提前定义好的一条路径，可以改进性能，并且消除帧和分组头的需求
2. 数据报服务
    * 网络层向上只提供简单灵活的、无连接的、尽最大努力交付的数据报服务
    * 不需要在发送分组时先建立连接

#### 网际协议IP
配套使用的三个协议：
1. 地址解析协议ARP - address resolution protocol
2. 网际控制报文协议ICMP - Internet control Message protocol
3. 网际组管理协议IGMP

虚拟互联网络  
* 当互联网上的主机进行通信时，就好像在一个网络上通信一样，而看不见互连的各具体的网络细节


网络互联要使用的一些中间设备：  
* 物理层：转发器  
* 数据链路层：网桥/交换机
* 网络层：路由器
* 网络层以上：网关

IP地址  
* 我们把整个因特网看成一个单一的，抽象的网络，IP地址就是给每个连接在因特网上的主机（或路由器）分配一个全世界唯一的32位标识符

分类IP地址
* IP地址 = {网络号net-id，主机号host-id}
* A类地址 --- 8，24
* B类地址 --- 16，16
* C类地址 --- 24，8
* D类地址 --- 多播地址
* E类地址 --- 保留

特殊IP地址
1. 全0 本网络上的本主机
2. 网络号0，host-id，本网络上的某台主机
3. 全1 只在本网络上进行广播
4. net-id，主机号全1，对net-id上的所有主机进行广播
5. net-id127，非全0或非全1的任何数，用于本地换回测试

IP地址的重要特点
1. 实际上ip地址是标志一个主机（或路由器）和一条链路的接口  
    （由于一个路由器至少应用连接到两个网络，因此一个路由器至少由两个不同的IP地址）
    
2. 用转发器、网桥、交换机连接起来的若干个局域网仍为一个网路，因此这些居于网都具有同样的网络号

地址解析协议ARP
* 在同一个局域网上传送数据帧时，必须使用硬件地址
* 每一个主机都有一个ARP高速缓存，里面有所在局域网上的各主机和路由器的IP地址到硬件地址的映射表
* 当主机A想要向本局域网主机B发送IP数据报时，A先在其ARP缓存中查看有无B的IP地址
    * 有，将硬件地址作为MAC目的地址
    * 无，广播发送ARP请求分组

ARP注意问题：  
* ARP解决了同一局域网上的主机或路由器的IP地址和硬件地址的映射问题
* 如果所要找的主机和源主机不在同一个局域网上，则ARP先找到一个位于本局域网上的某个路由器的硬件地址，然后这个路由器把分组转发给下一个网络

IP数据报格式
* 首部 + 数据
* 首部：固定20个字节，是所有IP数据报必须具有的

路由表
* 对于每一条路由，最主要的是（目的网络地址，下一跳网络地址）

路由表中问题
* IP数据报的首部中没有地方可以用来指明“下一跳路由器的IP地址”
* 当路由器收到待转发的数据报，而是送交下层的网络接口软件
* 网络接口软件使用ARP负责将将吓一跳路由器的IP地址转换成硬件地址，并将此硬件地址放在链路层的MAC帧的首部

IP路由
* 路由 --- 发送信息包时选择路径的过程
    * 当主机试图与其他主机通信时，IP首先判断目标主机是在本地还是异地
    * 若为本地或异地，检查路由表以寻找到达远程主机或网络的路径
    * 若没有找到路径，信息报被发送到默认路由器

分组转发算法
1. 从数据包首部提取目的主机IP地址D，得出网络地址为N
2. 若网络N与此路由器直接相连，则把数据报直接交付到目的主机D，否则间接交付
3. 若路由表有目的地址为D的特定主机路由，则转下一跳路由器
4. 若路由器有达到网络N的路由，则转下一跳路由器
5. 若有默认路由则，把数据报传送给默认路由
6. 转发分组出错

#### 划分子网和构造超网
1. 从两级IP地址到三级IP地址
2. 增加一个“子网号字段”，使两级IP到三级IP，这种做法叫划分子网

划分子网的基本思路
* 划分子网纯属一个单位内部的事情，单位对外仍然表现为没有划分子网的网络
* 从主机号借用若干位为子网号subnet-id
* IP地址 = {网络号，子网号，主机号}

划分子网后
* 从一个IP数据报的首部并无法判断源主机或目的主机所连接的网络是否进行了子网划分
* 使用子网掩码（sunet mask）可以找出IP地址中子网部分

子网掩码
* 子网掩码使是32位地址
    * 所有对应网络号的位置为1
    * 所有对应主机的位都置为1
* 子网掩码用于
    * 掩盖IP地址的一部分，从而分辨网络ID和主机ID
    * 区分目标主机IP地址是属于本地网络还是异地网络
* 每台在TCP/IP网络上的主机都需要子网掩码

子网掩码的重要属性
* 子网掩码是一个网络或一个子网的重要属性
* 路由器和相邻路由器交换路由信息是，必须将自己所在网络的子网掩码告诉相邻路由器
* 如一个路由器连接在两个子网上就拥有两个网络地址和两个子网掩码

在划分子网下的路由转发分组的算法
1. 用各网络的子网掩码和目的IP地址逐位相与，看是否和相应的网络地址匹配，若匹配，则将分组直接交付
2. 若路由表中有目的IP地址一样的主机路由，这将分组之间传送
3. 对路由表中的每一行的子网掩码和目的IP地址相与，匹配则传送
4. 若路由表中有一个默认路由，传送，否则报错


无分类域间路由选择CIDR----classless inter-domain routing
* CIDR两个主要特点
    * 消除了A类，B类，C类地址以及划分子网的概念
    * 按照地址块来分配地址
    * 把网络前缀都相同的连续IP地址组成一个CIDR地址块，从而减少这些地址在路由表中的表项数
* CIDR把32位IP地址划分为前后两个部分
    * 网络前缀，主机
    * IP地址={网络前缀，主机号}
* CIDR使用斜线记法
    * IP地址/前缀所占用的位数
    
路由聚合（或构成超网）
* 一个CIDR地址块可以表示很多地址，这种IP地址的聚合常称为路由聚合

最长前缀匹配
* 使用CIDR时，路由表中的每个项目由“网络前缀” 和 ”下一跳地址“组成
* 查找时可能会得到不止一个匹配结果
* 使用最长前缀匹配

使用二叉线索查找路由表

#### 网络控制报文协议ICMP
* 为了提高IP数据报交付成功的机会，在网际层使用了网际控制报文协议
* ICMP允许主机或路由器报告差错情况和提供有关异常情况的报告
* ICMP报文作为IP层数据报的数据，加上数据报首部，组成IP数据报发送出去

ICMP报文的种类
* ICMP差错报告报文
* ICMP询问报文

ICMP差错报告报文类型
* 终点不可达
* 时间超时
* 参数问题
* 改变路由（重定向）（Redirect）

ICMP询问报文
* 回送请求和回答报文
    * 测试目的站实浮可达以及了解有关状态
* 时间戳请求和回答报文
    * 请求某主机或路由器回答当前如期和时间

#### 因特网路由选择协议  
核心：路由算法-->获取路由表项

1. 自治系统AS --- Autonomous System
    * 定义：在单一的技术管理下的一组路由器
    * 不同的AS可以使用不同的内部路由选择协议和度量
    * 一个AS内部是一个单一的和一致的路由选择策略
    
内部网关协议IGP（interior gateway protocol）  
* RIP
    * 工作原理：基于距离向量，要求网络中每一个路由器都要维护从它自己到每一个目的网络的距离记录
    * 只适用于小型网络：距离最大值为16（意味不可达）
    * 仅和相邻路由器交换信息
    * 交换信息是当前本路由器所知道的全部信息，即自己的路由表
    * 按固定的时间间隔交换路由信息（每隔30s）
    
    * 主要缺点：好消息传播地快，坏消息传播地慢
* OSPF
    * 三个要点：
        1. 向本自治系统中所有路由器发送信息（洪泛法）
        2. 发送的信息是于本路由器相邻的所有路由器的链路状态
        3. 只有当链路状态发生变化时，路由器才用洪泛法向所有路由器发送此信息
        
    * 链路状态数据库
        * 各路由器之间频繁地交换链路状态信息，所有路由器最终都能建立一个链路状态数据库
        * 这个数据库实际上就是全网地拓扑结构1图
        * OSPF的更新过程快
        
    * 划分区域
    * 其他特点
        * 如果到同一个目的网络有多条相同代价的路径
        
外部网关协议EGP（external gateway protocol）  
* BGP是不同自治系统路由器之间交换信息的协议
* 自治系统之间的路由选择必须考虑有关策略：
    * 政治、安全、经济方面
    
BGP发言人
* 每一个自治系统的管理员要选择至少一个路由器作为该自治系统的BGP发言人
* 两个BGP发言人通过一个共享网络连接在一起

路由器在网际互连中的作用
1. 路由器的结构
    * 路由器：多端口的专用计算机，任务：转发分组
    
2. 转发 和 路由选择 的区别
    * 转发：根据转发表将用户的IP数据从合适的端口转发出去
    * 路由选择：按照分布式算法，动态改变路由
    

#### IPv6
* 更大地址空间，128位
* 即插即用

IPv6数据报首部
* 固定40字节（16+16+8）
* 8：版本，通信量类，流标号  / 有效载荷长度，下一个首部，跳数限制

* 通信量类：8位，为了区分不同的IPv6数据报的类别或优先级
* 有效载荷长度：16位
* 跳数限制：8位

IPv6的地址空间
* 单播：传统点对点通信
* 多播：一点对多点通信
* 任播：这是IPv6增加的一种类型，任播的目的站是一组计算机，但只交付其中一个

冒号十六进制记法

#### IP多播
IP多播特点
* 多播使用组地址
    * IP使用D类地址支持多播，多播地址只能用于目的地址，而不是用于源地址
    * D类地址前缀：1110
    
* IP多播两种：
    * 在本局域网上进行硬件多播
    * 另一种实在互联网上进行多播

多播协议体系结构
* 主机-路由器之间  ---- 网际组管理协议IGMP
* 路由器-路由器之间

#### 虚拟专用网络VPN和网络地址转换NAT
虚拟专用网VPN --- virtual private network
隧道技术

网络地址转换NAT
* NAT将私有IP地址转换为公网IP地址，使内部网可以连接到互联网

### 运输层
端到端的通信：应用进程通信
  







## java.net
### java基本网络支持
#### InetAddress类及其常用方法
InetAddress类对象包含一个Internet主机的域名和IP地址

* btye[] getAddress()   返回原始IP地址
* String getCanonicalHostName()   获取此IP地址的完全限定域名
* String getHostAddress()   获取此IP地址字符串
* String getHostName()   返回此IP地址的主机名
* static InetAddress getLocalHost()   返回本地主机

#### URLDecoder 和 URLEncoder
实现普通字符串和application/x-www-form-urlencoder字符串项目转换的功能

application/x-www-form-urlencoder  
* 基本格式：%XX%XX  XX为十六进制
* URL规定只能包含合法字符
    * URL元字符：; , / ? @ : & =
    * 语义字符；a-z A-Z 0-9 - _ . ! ~ * ' ()
* 其他字符都必须转义，规则是根据操作系统的默认编码

####URL类 和 URLConnection类
url.openConnection 获取URLConnection对象
 
### 基于TCP协议的网络变成
ServerSocket 类表示服务器端，Socke类表示客户端

基于TCP的套接字编程实现流程
1. 服务器端流程
    * 创建套接字 ServerSocket
    * 将套接字绑定到一个本地地址和端口上 bind
    * 将套接字设定为监听模式，准备接收客户端请求 listen
    * 阻塞等待一个客户端请求到来，当请求到来后，接受连接请求，返回一个新的客户端连接的套接字sockClient accept
    * 用返回的套接字sockClient和客户端进行通信 send/recv
    * 返回，等待另一个客户端请求
    * 关闭
2. 客户端流程
    * 创建套接字 socket
    * 向服务器发出连接请求 connect
    * 和服务器进行通信 send/recv
    * 关闭套接字
    
ServerSocket类  
用于在服务器上开一个端口，被动地等待数据，并建立连接进行数据交互（默认队列为50）

* ServerSocket构造：
    * 无参
    * port
    * port，backlog
    * port，backlog，bindaddr
* ServerSocket常用方法
    * Server accept
    * bind
    * close

Socekt类  
表示通信双方中的客户端，用于呼叫远端机器上的一个端口，进行数据交互

* Socket的构造方法
    * 无参
    * address， port
    * address， port， localaddr， localport
    * host， port
    * host， port， localaddr， localport
    
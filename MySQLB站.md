# MySQL 基础篇

***source：B站 尚硅谷 复习篇**

时间：2024年6月13号

## 00 前提

任何一样技术想要深入，体系必定是繁杂的，想要真正掌握，需要摸透底层的逻辑，梳理清知识脉络。最好以架构师的思路和视野学习MySQL，这样才能以不变应万变。高压面试、工作实战、团队骨干中拥有核心竞争力。

学习内容：

- 涉及MySQL版本：MySQL5.7和MySQL8.0.26

- 融合了几乎所有语法、调优、底层新特性

- MySQL初学者、从事1~3年开发和运维、有资历的MySQL DBA

- 基础篇：重点在第二章，其中多表查询和子查询较复杂

  ![image-20240613164149312](C:\Users\QMacroQA\AppData\Roaming\Typora\typora-user-images\image-20240613164149312.png)

- 高级篇：

  ![image-20240613164348857](C:\Users\QMacroQA\AppData\Roaming\Typora\typora-user-images\image-20240613164348857.png)



面对一些面试题：

- MySQL底层是如何组织设计数据的
- 如何理解“索引即数据，数据即索引”
- 索引下推、覆盖索引对优化有何优势
- 海量数据和高并发场景如何设计主键
- MVCC如何解决可重复读下的幻读
- ...

资料涉及：

- 7大SQL性能分析工具
- 10大类30小类SQL优化场景7大日志剖析6大范式讲解
- 15个xx锁的应用
- 11大适合创建索引场景
- 300+张高清无码技术剖析图...

学习资料：

- https://dev.mysql.com/doc/refman/8.0/en/   MySQL的官网，参考较多
- 旧金山大学大学的校内网站，涉及索引相关的数据结构的动画演示
  - https://www.cs.usfca.edu/~galles/visualization/about.html 需要vpn
- 教材《MySQL是怎样运行的》已经购买



## 01 数据库概述

详细的还是看PDF课件

**1、为什么使用数据库**

持久化；

存储量大，有各种方法查询，更快速；

存储结构复杂的数据



**2、数据库与数据库管理系统**

**2.1、数据库的相关概念**

**DB：数据库（Database）** 即存储数据的“仓库”，其本质是一个文件系统。它保存了一系列有组织的数据。 

**DBMS：数据库管理系统（Database Management System）** 是一种操纵和管理数据库的大型软件，用于建立、使用和维护数据库，对数据库进行统一管理和控 制。用户通过数据库管理系统访问数据库中表内的数据。

 **SQL：结构化查询语言（Structured Query Language）** 专门用来与数据库通信的语言



**2.2、数据库与数据库管理系统的关系**

![image-20240613170746000](C:\Users\QMacroQA\AppData\Roaming\Typora\typora-user-images\image-20240613170746000.png)

**2.3、常见的数据库管理系统排名（DBMS）**

[DB-Engines Ranking - popularity ranking of database management systems](https://db-engines.com/en/ranking)

![image-20240613171303386](C:\Users\QMacroQA\AppData\Roaming\Typora\typora-user-images\image-20240613171303386.png)

对应的走势图：[historical trend of the popularity ranking of database management systems (db-engines.com)](https://db-engines.com/en/ranking_trend)

![image-20240613171423770](C:\Users\QMacroQA\AppData\Roaming\Typora\typora-user-images\image-20240613171423770.png)

**2.4、常见的数据库介绍**

oracle、SQLserve、sqllite（嵌入式小型数据库，在移动端）

之前工作接触过Redis（查看数据）、elasticsearch（搜索）、MongoDB（面试）、SQLserver（面试）



**3、MySQL介绍**

**3.1、概述**

- MySQL是一个 开放源代码的关系型数据库管理系统，由瑞典MySQL AB（创始人Michael Widenius）公 司1995年开发，迅速成为开源数据库的 No.1。
-  2008被 Sun 收购（10亿美金），2009年Sun被 Oracle 收购。 MariaDB 应运而生。（MySQL 的创 造者担心 MySQL 有闭源的风险，因此创建了 MySQL 的分支项目 MariaDB）
-  MySQL6.x 版本之后分为 社区版和 商业版。
-  MySQL是一种关联数据库管理系统，将数据保存在不同的表中，而不是将所有数据放在一个大仓库 内，这样就增加了速度并提高了灵活性。
-  MySQL是开源的，所以你不需要支付额外的费用。
-  MySQL是可以定制的，采用了 GPL（GNU General Public License） 协议，你可以修改源码来 开发自己的MySQL系统。
-  MySQL支持大型的数据库。可以处理拥有上千万条记录的大型数据库。 
- MySQL支持大型数据库，**支持5000万条记录的数据仓库，32位系统表文件最大可支持 统支持最大的表文件为 8TB** 。 
- MySQL使用 标准的SQL数据语言形式。 4GB ，64位系 
- MySQL可以允许运行于多个系统上，并且支持多种语言。这些编程语言包括C、C++、Python、 Java、Perl、PHP和Ruby等。

**3.2、MySQL发展史重大事件**

MySQL的历史就是整个互联网的发展史。互联网业务从社交领域、电商领域到金融领域的发展，推动着 应用对数据库的需求提升，对传统的数据库服务能力提出了挑战。高并发、高性能、高可用、轻资源、 易维护、易扩展的需求，促进了MySQL的长足发展。

时间节点图：2000年 ISAM转为MyISAM存储引擎，同年开放了自己的源代码，并基于GPL许可协议

2001年，MySQL开始集成InnoDB存储引擎

2010年，InnoDB存储引擎为MySQL的默认存储引擎

2018年，MySQL8.0.11 GA版本正式发布

MySQL从5.7版本直接跳跃发布了8.0版本 ，可见这是一个令人兴奋的里程碑版本。MySQL 8版本在功能上 做了显著的改进与增强，开发者对MySQL的源代码进行了重构，最突出的一点是多MySQL Optimizer优化 器进行了改进。不仅在速度上得到了改善，还为用户带来了更好的性能和更棒的体验。

**4、RDBMS和非RDBMS**

**4.1 关系型数据库(RDBMS)**

  **4.1.1 实质** 

-  这种类型的数据库是 最古老的数据库类型，关系型数据库模型是把复杂的数据结构归结为简单的 二元关系（即二维表格形式）。
- 关系型数据库以 行(row) 和 列(column) 的形式存储数据，以便于用户理解。这一系列的行和列被称为表（table），一组表组成了一个库（database）。
- 表与表之间的数据记录有关系(relationship)。现实世界中的各种实体以及实体之间的各种联系均用 关系模型 来表示。关系型数据库，就是建立在 关系模型 基础上的数据库。
- SQL 就是关系型数据库的查询语言。

 **4.1.2、优势**  

复杂查询 可以用SQL语句方便的在一个表以及多个表之间做非常复杂的数据查询。 事务支持 使得对于安全性能很高的数据访问要求得以实现。

**4.2 非关系型数据库(非RDBMS)**

  **4.2.1 介绍**  

非关系型数据库，可看成传统关系型数据库的功能 的解析， 阉割版本，基于键值对存储数据，不需要经过SQL层 性能非常高。同时，通过减少不常用的功能，进一步提高性能。 目前基本上大部分主流的非关系型数据库都是免费的。 

**4.2.2 有哪些非关系型数据库**

Redis：key-value型数据库，缓存级别数据库

MongoDB：文档型数据库

Solr、Elasticsearch：搜索引擎数据库；核心原理是“倒排索引”。

Neo4J、InfoGrid：图形数据库。网络关系结构

HBase：列式数据库



## 02 数据库安装


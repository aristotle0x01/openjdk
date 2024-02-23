- GC roots
- Safepoints
- 堆的分代及初始化
- 对象内存分配，TLAB
- serial collector
- 垃圾回收线程管理



**分代回收概念阐释**

[Back To Basics: Generational Garbage Collection](https://blog.bonggeek.com/2009/03/back-to-basics-generational-garbage.html)



**Q**: 什么是GC roots？

**A**: 在jvm语言及实现层面先讲清楚这个问题，再讲看hotspot垃圾回收更有意义，但是可惜的是很少文章或者书籍从这个角度出发。

[Finding References in Java™ Stacks](https://www.researchgate.net/profile/David-Detlefs/publication/2781137_Finding_References_in_Java_Stacks/links/53d876c40cf2e38c6331771d/Finding-References-in-Java-Stacks.pdf)

[Memory Management Reference](https://www.memorymanagement.org/index.html)



**Q**: 什么是conservative收集器？

**A**: [The Java HotSpot Garbage Collector: Accuracy](https://www.oracle.com/java/technologies/whitepaper.html)

[Accurate Garbage Collection in Uncooperative Environments Revisited](http://www.filpizlo.com/papers/baker-ccpe09-accurate.pdf)

[A garbage collector for C and C++](https://hboehm.info/gc/)



**Q**: 对象头中的mark字段是如何在GC起到forward pointer作用的？

**A**: 

> When an object is moved by the garbage collector, the new object address, 
>
> called the forward pointer, is also stored in the mark word. If the hash code 
>
> bits are used, they are rescued before they are overwritten
>
> https://ssw.jku.at/Research/Papers/Wuerthinger11PhD/Wuerthinger11PhD.pdf
>
>   // Figure 2.9: The mark-and-compact garbage collection algorithm p24

<img src="https://github.com/aristotle0x01/openjdk/assets/2216435/617fce5a-9ddf-4751-9ee5-bf2a4fe992e0" alt="forward pointer" style="zoom:60%; float: left;" />


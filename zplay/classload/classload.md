Q: classloader为什么要进行namespace隔离？

A: 

> By allowing you to instantiate user-defined class loaders that know how to download class files across a network, Java's class loader architecture supports network-mobility. It supports security by allowing you to load class files from different sources through different user-defined class loaders. This puts the class files from different sources into different name-spaces, which allows you to restrict or prevent access between code loaded from different sources.



## class file format

[Chapter 4. The `class` File Format](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7)

![class file format](https://user-images.githubusercontent.com/2216435/285096072-36305922-a3c5-40ba-903d-dd31c7dd091c.png)



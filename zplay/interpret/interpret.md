## 关于方法调用(解释执行)的一些思考

1.关于Cppinterpreter vs TemplateInterpreter

[Demystifying the JVM: JVM Variants, Cppinterpreter and TemplateInterpreter](https://metebalci.com/blog/demystifying-the-jvm-jvm-variants-cppinterpreter-and-templateinterpreter/)

2.解释执行及栈的变化

[第38篇-解释执行之方法调用小实例](https://www.cnblogs.com/mazhimazhi/p/15523953.html)

3.gdb debug hotspot源码

[Analyzing and Debugging the HotSpot VM at the OS Level](https://www.progdoc.de/papers/JavaOne2014/javaone2014_con3138.html)

4.关于class vframe栈结构在hotspot使用的一些疑惑

```c++
class frame;

class vframe;
class   javaVFrame;
class     interpretedVFrame;
class     compiledVFrame;
class     deoptimizedVFrame;
class   externalVFrame;
class     entryVFrame;
```

根据perplexity.ai(及相关资料和源码):

问：

>remember the diffrence, when a java method is called,  tell me if it explicitly create a vframe or its desendents of the vframe class, or implicitly push on stack a frame which logically can be regarded as a vframe?

答：

> When a Java method is invoked, a new frame is created and pushed onto the thread's stack. This new frame becomes the current frame, and it is used to store parameters, local variables, intermediate computations, and other data as the method executes. The frame is created implicitly by the JVM and can be regarded as a `vframe` or its descendants, as it fulfills the same purpose of storing the method's state and data during its execution

class vframe主要辅助用在debug及间接获取栈结构时使用，在常规调用java method的时候，并不会显式实例化一个vframe来

作为栈帧，而是通过汇编代码隐式构造了栈帧，逻辑上可以视为一个vframe结构。

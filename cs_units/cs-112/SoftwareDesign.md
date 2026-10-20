**CS 112**
- X
- Y
- Z


# Software engineering design: techniques and strategies

**What This Covers**
- Memory management and garbage collection
- Visibility, scope, binding, and lifetime.


### Explanations

**Garbage**

this is automacticly handled in java but an example to avoid memory leaks is to set un needed values to null to prevent data from piling up and leading to a crash from the memory leak



**Visibility, scope, binding, and lifetime.**

```java
int var = 1


public void exampleMethod(){
    int var2 = var + var
}

var = var2 // INVALID

```


Scope is very important in all programing languages. If you try to call something out of scope it will not work! Scope is mainly seen in {} with variable being defined in higher layers are able to be used in lower layers with lower layer vars not being able to be used in higher layers or possible even lower layers if defined in a way where theres 2 scopes in 1 layer
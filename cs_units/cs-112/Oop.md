**CS 112 - Object-oriented programming (OOP): design and analysis**
- OOP: design and analysis
- Encapsulation, inheritance, and polymorphism
- Abstract classes and generics or parameterized types

# OOP: design and analysis

**What This Covers**
- Classes
- Objects
- Constructors

### Explanations

```java
class Car extends Vehicle{ // ignore extends for now
    public Car(){
        this.Color = "Blue";
        this.Make = "Ford F-150";
    }


    public Car(String color, String make){
        this.Color = color;
        this.Make = make;
    }

    public Car(String color, String make, boolean running, String[] stuffInside, double fuel){
        super(color, make, running, stuffInside, fuel); // ignore super for now
    }
}
```
This code snippet demonstraights Classes, Objects, and constructors all in one.

This covers classes as I create class **Car** which contains values such as model and make

This covers Objects as the **Car** class is considered as its own object allowing for special callings such as
```java
    Car testCar2 = new Car("Red", "Toyota");
```

This also covers constructers through the function below

```java
    public Car(){
        this.Color = "Blue";
        this.Make = "Ford F-150";
    }
```

using the same name as the class will create a constructer that is called when a new instance is created of the class


# Encapsulation, inheritance, and polymorphism

**What This Covers**
- Encapsulation, inheritance, and polymorphism


### Explanations

Example of Encapsulation

```java
class Vehicle{
    private ArrayList<String> stuffInside = new ArrayList<>();
    private double Fuel;

    public String Color;
    public String Make;
    public boolean Running;

    //...end of snippet
```

Shows both public and private values in the **Vehicle** class

```java
    public ArrayList<String> getStuff(){
        return this.stuffInside;
    }

    public double getFuel(){
        return this.Fuel;
    }
```

this shows how the private variables are acsessable. As you can see they are READ ONLY! (exepct in my code where I demosntraight with the ability to also write)

Example of inheritance

```java
class Car extends Vehicle{
    public Car(){
        this.Color = "Blue";
        this.Make = "Ford F-150";
    }


    public Car(String color, String make){
        this.Color = color;
        this.Make = make;
    }

    public Car(String color, String make, boolean running, String[] stuffInside, double fuel){
        super(color, make, running, stuffInside, fuel);
    }
}
```


This snippet uses special statments showing inheritance. such as **extends** and **super()**

super() triggers the constructer for the parent class

extends makes the class a child of the parent class inheriting its methods and values

Example of polymorphism

```java
    public Car(){
        this.Color = "Blue";
        this.Make = "Ford F-150";
    }


    public Car(String color, String make){
        this.Color = color;
        this.Make = make;
    }

    public Car(String color, String make, boolean running, String[] stuffInside, double fuel){
        super(color, make, running, stuffInside, fuel);
    }
```

This shows polymorphism through the multiple diffrent constructer methods ranging in values.

Another important statment is **@overide** which can allow you to use a defined function rather than the parents

for example if I had a run() method in the vehicle in the car i can create my own @override run() to use the values in the cars run rather than the vehichles




# Abstract classes and generics or parameterized types

**What This Covers**
- Absract Classes
- Generics


### Explanations

```java

```

Explanation Here
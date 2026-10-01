public class OopTwo{
    public static void main(String[] args){
        CarTwo myCar = new CarTwo();
        myCar.Start();
    }
}

abstract class VehicleTwo{
    abstract void Start();
} 


interface HasMotor{
    public void StartMotor();
    public void StopMotor();
}


class CarTwo extends VehicleTwo implements HasMotor{
    
    @Override 
    public void Start(){
        this.StartMotor();
    }

    @Override 
    public void StartMotor(){
        System.out.println("Starting Motor!");
    }

    @Override 
    public void StopMotor(){
        System.out.println("Stopped Motor!");
    }
}


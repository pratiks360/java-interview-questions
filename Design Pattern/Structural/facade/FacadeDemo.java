package Structural.facade;

// Subsystem classes
class CPU {
    void start() {
        System.out.println("CPU started");
    }

    void execute() {
        System.out.println("CPU executing");
    }
}

class Memory {
    void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    void readData() {
        System.out.println("Hard drive reading data");
    }
}

// Facade
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
    }
}

public class FacadeDemo {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}


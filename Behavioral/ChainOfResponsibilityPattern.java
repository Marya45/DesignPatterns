/*
The Chain of Responsibility (CoR) Pattern allows a request to pass through a chain of handlers until one of them handles it.
Instead of one class knowing how to handle every request, each handler gets a chance to process it.

Imagine customer support : 

Suppose a customer requests a refund.
Level 1 cannot approve it.
It forwards it to Level 2.
Level 2 cannot approve it.
Manager approves it.

The customer doesn't know who will handle the request.
*/

abstract class LeaveApprover {

    protected LeaveApprover next;

    public void setNext(LeaveApprover next) {
        this.next = next;
    }

    public abstract void approve(int days);
}

class TeamLead extends LeaveApprover {

    @Override
    public void approve(int days) {

        if(days <= 2) {
            System.out.println("Approved by Team Lead");
        }
        else {
            next.approve(days);
        }
    }
}

class Manager extends LeaveApprover {

    @Override
    public void approve(int days) {

        if(days <= 5) {
            System.out.println("Approved by Manager");
        }
        else {
            next.approve(days);
        }
    }
}

class Director extends LeaveApprover {

    @Override
    public void approve(int days) {

        System.out.println("Approved by Director");
    }
}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {

        LeaveApprover lead = new TeamLead();

        LeaveApprover manager = new Manager();

        LeaveApprover director = new Director();

        lead.setNext(manager);
        manager.setNext(director);
        lead.approve(4);
    }
}

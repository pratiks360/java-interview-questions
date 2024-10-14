package behavioural;


interface State {
    void publish(DocumentContext context);

    void edit(DocumentContext context);
}

class DraftState implements State {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document published, moving to Moderation state.");
        context.setState(new ModerationState());
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Document is in Draft state, you can edit it.");
    }
}

class ModerationState implements State {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document approved and published.");
        context.setState(new PublishedState());
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Document is in Moderation state, you cannot edit it.");
    }
}

class PublishedState implements State {
    @Override
    public void publish(DocumentContext context) {
        System.out.println("Document is already published, cannot publish again.");
    }

    @Override
    public void edit(DocumentContext context) {
        System.out.println("Document is published, you cannot edit it anymore.");
    }
}

class DocumentContext {
    private State state;

    public DocumentContext() {
        // Initial state is Draft
        this.state = new DraftState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void publish() {
        state.publish(this);
    }

    public void edit() {
        state.edit(this);
    }
}


public class StatePatternDemo {
    public static void main(String[] args) {
        DocumentContext document = new DocumentContext();

        document.edit();     // Output: Document is in Draft state, you can edit it.
        document.publish();  // Output: Document published, moving to Moderation state.

        document.edit();     // Output: Document is in Moderation state, you cannot edit it.
        document.publish();  // Output: Document approved and published.

        document.edit();     // Output: Document is published, you cannot edit it anymore.
        document.publish();  // Output: Document is already published, cannot publish again.
    }
}


public class FakeStackDAO implements IStackDAO {

    @Override
    public void save(Stack stack) {
        System.out.println("Not communicate with Database");
    }
}

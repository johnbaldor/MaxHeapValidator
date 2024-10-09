import org.junit.Test;

import java.time.chrono.MinguoChronology;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Examples {
    public Examples(){}

    @Test
    public void TestMinHeap(){
        MinHeapValidator val = new MinHeapValidator();
        assertTrue(val.validAdd(new NodeBT(3, mt, new NodeBT(7, mt, mt)), 5, new NodeBT(3, new NodeBT(5, mt, mt), new NodeBT(7, mt, mt))));
        assertTrue(val.validRemove( new NodeBT(3, new NodeBT(5, mt, mt), new NodeBT(7, mt, mt)),7, new NodeBT(3, new NodeBT(5, mt, mt), mt)));
        assertFalse(val.validAdd(new NodeBT(6, new NodeBT(4, mt, mt), new NodeBT(1, mt, mt)), 3, new NodeBT(6, new NodeBT(4, mt, mt), new NodeBT(1, new NodeBT(3, mt, mt), mt))));
        assertFalse(val.validRemove( new NodeBT(8, new NodeBT(5, mt, mt), new NodeBT(7, mt, mt)),5, new NodeBT(8, mt, new NodeBT(7, mt, mt))));
        assertFalse(val.validRemove( new NodeBT(3, new NodeBT(5, mt, mt), new NodeBT(7, mt, mt)),6, new NodeBT(8, new NodeBT(5, mt, mt), new NodeBT(7, mt, mt))));
    }

    IBinTree mt = new EmptyBT();

    // contains
    @Test
    public void validateAddedContainsElt(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertTrue(validator.validAdd(mt, 3, new NodeBT(3, mt, mt)));
        assertFalse(validator.validAdd(mt, 3, new NodeBT(4, mt,mt)));
    }

    @Test
    public void validateAddedContainsElt2(){
        BinaryTree bt = new BinaryTree();
        bt.addInt(3);
        bt.setValidator(new MaxHeapValidator());

        BinaryTree goodHeap = new BinaryTree(bt);
        goodHeap.setStrategy(new MaxHeapStrategy1());

        BinaryTree badHeap = new BinaryTree(bt);
        badHeap.setStrategy(new FaultyMaxHeapStrategy1());

        assertTrue(goodHeap.addInt(2));
        assertFalse(badHeap.addInt(4));
    }

    @Test
    public void validateAddedContainsElt4(){
        BinaryTree bt = new BinaryTree();
        bt.addInt(6);
        bt.addInt(5);
        bt.addInt(7);
        bt.addInt(10);
        bt.setValidator(new MaxHeapValidator());

        BinaryTree goodHeap = new BinaryTree(bt);
        goodHeap.setStrategy(new MaxHeapStrategy1());

        BinaryTree badHeap = new BinaryTree(bt);
        badHeap.setStrategy(new FaultyMaxHeapStrategy1());

        assertTrue(goodHeap.removeInt(6));
        assertFalse(badHeap.removeInt(5));


    }
    @Test
    public void validateRemovedContainsEltEmpty(){
        MaxHeapValidator validator = new MaxHeapValidator();
        assertFalse(validator.validRemove(mt, 3, new NodeBT(3, mt, mt)));
        assertFalse(validator.validRemove(mt, 3, new NodeBT(4, mt,mt)));
    }


}

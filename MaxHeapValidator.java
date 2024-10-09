public class MaxHeapValidator implements BTValidator{
    /**
     * Check if adding i to the old tree and getting the new tree is possible with the current invariants
     *
     * @param oldTree the given tree we assume respects the invariants
     * @param i       the element to add
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validAdd(IBinTree oldTree, int i, IBinTree newTree) {
        return this.contains(newTree, i) && this.allIn(oldTree, newTree) && newTree.size() == oldTree.size() + 1 &&
                this.isMaxHeap(newTree);
    }
    /**
     * Check if removing i from the old tree and getting the new tree is possible with the current invariants
     *
     * @param oldTree the given tree we assume respects the invariants
     * @param i       the element to remove
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validRemove(IBinTree oldTree, int i, IBinTree newTree) {
        return (! this.contains(newTree, i)) && this.allIn(newTree, oldTree) && newTree.size() == oldTree.size() -1 &&
                this.isMaxHeap(newTree);
    }



    private boolean isMaxHeap(IBinTree aTree ){
        if(aTree.isEmpty()) {
            return true;
        }
        else {
            boolean left = this.biggerThanAll(aTree.getRoot(), aTree.getLeft());
            boolean right = this.biggerThanAll(aTree.getRoot(), aTree.getRight());
            return left && right ;}
    }

    private boolean biggerThanAll(int elt, IBinTree aTree){
        if(aTree.isEmpty()){
            return true;
        }
        else{
            return elt > aTree.getRoot() &&
                    this.biggerThanAll(aTree.getRoot(), aTree.getLeft()) && this.biggerThanAll(aTree.getRoot(), aTree.getRight());
        }
    }


    private boolean contains(IBinTree aTree, int i ){
            if(aTree.isEmpty()){
        return false;
    }
        else {
        return aTree.getRoot() == i || this.contains(aTree.getLeft(), i) || this.contains(aTree.getRight(), i);
    }}

    private boolean allIn(IBinTree elements, IBinTree container){ // O(n^2)
        if(elements.isEmpty()){
            return true;
        }
        else{
            return this.contains(container, elements.getRoot()) && //O(n)
                    this.allIn(elements.getLeft(), container) &&
                    this.allIn(elements.getRight(), container);
        }
    }

}



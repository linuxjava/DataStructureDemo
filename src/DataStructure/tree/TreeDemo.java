package DataStructure.tree;

public class TreeDemo {
    public static void main(String[] args){
        SearchTree searchTree = new SearchTree();

        searchTree.insert(1);
        searchTree.insert(34);
        searchTree.insert(456);
        searchTree.insert(42);
        searchTree.insert(3245234);
        searchTree.insert(3244);
        searchTree.insert(20);
        searchTree.insert(90);
        searchTree.insert(54);

        int key = -3245234;
        SearchTree.Node findNode = searchTree.find(key);
        if(findNode == null){
            System.out.println("未找到节点 = " + key);
        }else {
            System.out.println("找到节点 = " + findNode.data);
        }

        searchTree.middleTraversal(searchTree.getRoot());

        searchTree.preTraversal(searchTree.getRoot());
        searchTree.afterTraversal(searchTree.getRoot());
    }
}

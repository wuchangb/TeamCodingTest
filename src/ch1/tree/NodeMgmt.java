package ch1.tree;

import javax.xml.crypto.Data;

public class NodeMgmt {

    Node head = null;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertNode(int data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            Node findNode = this.head;
            while (true) {
                if (findNode.value < head.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node search(int data) {
        if (this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    public boolean delete(int data) {
        boolean searched = false;
        Node currNode = this.head;
        Node currParentNode = this.head;

        if (this.head == null) {
            return false;
        } else if (this.head.value == data && this.head.left == null && this.head.right == null) {
            this.head = null;
            return true;
        } else {
            while (currNode != null) {
                if (currNode.value == data) {
                    searched = true;
                    break;
                } else if (data < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched != true) {
                return false;
            }
        }
        //삭제할 node 가 leaf node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (data < currParentNode.value) {
                currParentNode.left = null;
            } else {
                currParentNode.right = null;
            }
        } else if (currNode.left != null && currNode.right == null) {              //삭제할 node가 child 한개인 경우(왼쪽)
            if (data < currParentNode.value) {
                currParentNode.left = currNode.left;
            } else {
                currParentNode.right = currNode.left;
            }
            return true;
        } else if (currNode.left == null && currNode.right != null) {               //삭제할 node가 child 한개인 경우(오른쪽)
            if (data < currParentNode.value) {
                currParentNode.left = currNode.right;
            } else {
                currParentNode.right = currNode.right;
            }
            return true;
        } else {        // Case3-1: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)

            if (data < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음
                if (changeNode.right != null) {
                    // Case 3-1-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-1-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }
                currParentNode.left = changeNode;
                changeNode.left = currNode.left;
                changeNode.right = currNode.right;

            } else {        // Case3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 오른쪽 있을 때)
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음

                if (changeNode.right != null) {
                    // Case 3-2-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-2-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode 의 오른쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                // 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

            }
        }
        return true;
    }


    public static void main(String[] args) {
        NodeMgmt tree = new NodeMgmt();
        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(4);
        tree.insertNode(6);
    }
}

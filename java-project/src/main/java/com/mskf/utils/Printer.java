package com.mskf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zly on 2018/2/5.
 */
public class Printer {

    //print str
    public static String print(String string, boolean getResult){
        String str = string;
        if(getResult){
            System.out.println(str);
        }
        return str;
    }

    //print bool
    public static String print(boolean bool, boolean getResult){
        String str = String.valueOf(bool);
        if(getResult){
            System.out.println(str);
        }
        return str;
    }

    //print long
    public static String print(long longv, boolean getResult){
        String str = String.valueOf(longv);
        if(getResult){
            System.out.println(str);
        }
        return str;
    }

    //print int
    public static String print(int intv, boolean getResult){
        String str = String.valueOf(intv);
        if(getResult){
            System.out.println(str);
        }
        return str;
    }

    //print int array
    public static String print(int[][] arrs, boolean getResult){
        StringBuilder sb = new StringBuilder();
        Arrays.asList(arrs).forEach(s->sb.append(s).append("\n"));
        if(getResult){
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    //convert to string and using stream API
    public static String print(int[] arr, boolean getResult){
        String str = Arrays.stream(arr).parallel()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        if(getResult){
            System.out.println(str);
        }
        return str;
    }

    //print collection
    public static String print(ArrayList objs, boolean getResult){
        return print(objs,getResult,0);
    }
    public static String print(List objs, boolean getResult){
        return print(objs,getResult,0);
    }
    public static String print(List objs, boolean getResult,int level){
        StringBuilder sb = new StringBuilder();
        if(objs!=null && objs.size()>0){
            if(objs.get(0) instanceof List){
                for(Object obj:objs)
                    sb.append(print((List<Object>)obj, getResult,level+1));
            }else{
                sb.append(String.valueOf(objs.parallelStream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))));
            }
        }

        if(level==0 && getResult)
            System.out.println(sb.toString());

        return sb.toString();
    }

    //方便切换是否打印输出
    public static void print(Object obj){
        try{
            Method method = Printer.class.getMethod("print",new Class[]{obj.getClass(),boolean.class});
            method.invoke(null,obj,true);
        }catch (Exception e){
            System.out.println("Type not match");
        }
    }

    public static void main(String[] args){
        Tree node = new Tree(16126161);
        node.left = new Tree(2);
        node.right = new Tree(1233);
        node.left.left = new Tree(4);
        // node.left.right = new Tree(5123);
        // node.left.left.left = new Tree(6);
        node.right.right = new Tree(7);
        printTree(node);
    }

    //测试打印树
    public static class Tree{
        public int val;
        public Tree left;
        public Tree right;
        Tree(int val){
            this.val = val;
        }
    }

    public static void printTree(Object root){
        if(root!=null){
            int MAXH = 6,height = treeHeight(root);

            if(height>MAXH){
                System.out.print("树的最大深度为"+MAXH);
            }else{
                int maxLevel = 0;
                Queue<Node> queue = new LinkedList<Node>();
                Node nodeRoot = new Node(root,null);
                nodeRoot.level = 0;

                queue.add(nodeRoot);
                while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    Object left = treeLeft(cur.object);
                    Object right = treeRight(cur.object);
                    maxLevel = Math.max(maxLevel,cur.level);
                    if(left!=null){
                        queue.add(new Node(left,cur));
                    }

                    if(right!=null){
                        queue.add(new Node(cur,right));
                    }
                }

                //依次打印树结构，注意换行

                //调整一下树
                queue.add(nodeRoot);
                while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    if(cur!=null){
                        if(cur.level<maxLevel){//在适当的地方插入空元素
                            if(cur.left==null){
                                cur.left = new Node(cur, cur.width);
                            }

                            if(cur.right==null){
                                cur.right = new Node(cur, cur.width);
                            }
                        }
                        queue.add(cur.left);
                        queue.add(cur.right);
                    }
                }

                int preLevel = 0;
                List<String> structure = new ArrayList<String>();
                StringBuilder curBuilder = new StringBuilder();
                StringBuilder curDownBuilder = new StringBuilder();
                queue.add(nodeRoot);
                while(true){
                    Node cur = queue.peek();

                    if(cur==null || cur.level!=preLevel){
                        structure.add(curBuilder.toString());
                        structure.add(curDownBuilder.toString());

                        curBuilder.delete(0,curBuilder.length());
                        curDownBuilder.delete(0,curDownBuilder.length());
                        

                        if(cur==null)
                            break;
                        else
                            preLevel = cur.level;
                    }

                    queue.poll();

                    curBuilder.append(strWithIn(cur.strVal, cur.width));

                    //树结构字符
                    curDownBuilder.append(strWithIn("/", cur.width/2));
                    curDownBuilder.append(strWithIn("\\", cur.width-cur.width/2));

                    if(cur.left!=null){
                        queue.add(cur.left);
                    }

                    if(cur.right!=null){
                        queue.add(cur.right);
                    }
                }

                for(int i=0;i<structure.size()-1;i++){
                    System.out.println(structure.get(i));
                }
            }
        }
    }

    private static class Node{
        Object object = null;

        Node parent = null;
        Node left = null;
        Node right = null;
        
        String strVal = "";
        int level;
        int height;

        int width;
        int lwidth;
        int rwidth;

        void create(Object object){
            this.object = object;
            this.strVal = treeValue(object);
            this.width = this.strVal.length();
            this.height = 1;
            this.lwidth = 0;
            this.rwidth = 0;
        }

        Node(Node parent,int width){//empty node
            this.strVal = "";
            this.width = width;
            this.level = parent.level+1;
        }

        Node(Object object,Node parent){//left node
            create(object);

            this.parent = parent;

            if(parent!=null){
                this.level = parent.level+1;
                parent.left = this;
                fixWidth(parent);
            }else{
                this.level = 0;
            }
        }

        Node(Node parent,Object object){//right node
            create(object);
            this.parent = parent;

            if(parent!=null){
                this.level = parent.level+1;
                parent.right = this;
                fixWidth(parent);
            }else{
                this.level = 0;
            }
        }

        //辅助方法，用于调整每一个节点的宽度
        private static void fixWidth(Node node){
            while(node!=null){

                if(node.left!=null || node.right!=null){
                    //根据左右子树的宽度调整当前树的宽度，取所有宽度中的最大值，其中只要有任意子树存在，另一颗子树宽度就是3，而且子树宽度不能小于3，不然没法显示出树状结构
                    node.width = Stream.of(node.width,node.lwidth+3,node.rwidth+3,6).reduce(Integer::max).get();
                }
                
                if(node.parent!=null){
                    if(node.parent.left==node){
                        node.parent.lwidth = node.width;
                    }else{
                        node.parent.rwidth = node.width;
                    }
                }
                node = node.parent;
            }
        }
    }



    //以下是一些私有辅助方法，多数用于树结构操作，反射等等

    private static Object reflector(Object source,String[] names,Object orGet){
        Object res = orGet;
        try{
            Class cls = source.getClass();
            Field value = null;
            for(Field field:cls.getFields()){
                for(String name:names){
                    if(name.equals(field.getName())){
                        value = field;
                        break;
                    }
                }

                if(value!=null){
                    break;
                }
            }
            if(value != null)
                res = value.get(source);
        }catch(Exception e){
            res = orGet;
            e.printStackTrace();
        }
        return res;
    }
    private static String treeValue(Object node){
        return String.valueOf(reflector(node,new String[]{"value","val"},""));
    }
    private static Object treeLeft(Object node){
        return reflector(node,new String[]{"left","leftChild"},null);
    }
    private static Object treeRight(Object node){
        return reflector(node,new String[]{"right","rightChild"},null);
    }
    private static int treeHeight(Object root){
        if(root==null)
            return 0;
        return 1+Math.max(treeHeight(treeLeft(root)),treeHeight(treeLeft(root)));
    }

    private static String strWithIn(String str,int max){
        int prevSpace = (max-str.length())/2;
        int nextSpace = max - prevSpace -str.length();
        return (prevSpace>0?String.format("%1$"+prevSpace+"s", ""):"") + str + (nextSpace>0?String.format("%1$"+nextSpace+"s", ""):"");
    }
}

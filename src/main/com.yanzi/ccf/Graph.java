package com.yanzi.ccf;

import java.util.Scanner;

public class Graph {	        
	     //定义一个点
	        class Vertex{
	        	public int label;
	        	public boolean isInTree;	        	
	        	public Vertex(int label){
	        		this.label = label;
	        		isInTree = false;
	        	}
	        }
	        //加入边
	        class Edge{
	        	public int srcVert;
	        	public int desVert;
	        	public int distance;
	        	public Edge(int sv, int dv, int d){
	        		srcVert = sv;
	        		desVert = dv;
	        		distance = d;
	        	}
	        }
	        //////优先级队列中，每次取出的都是值最小的
	        class PriorityQ{
	        	private final int SIZE = 1000;
	        	private Edge[] queArray;
	        	private int size;
	        	
	        	public PriorityQ(){
	        		queArray = new Edge[SIZE];
	        		size = 0;
	        	}
	        	
	        	public void insert(Edge item){
	        		int j;
	        		for(j = 0; j < size; j ++){   //find place to insert
	        			if(item.distance >= queArray[j].distance)
	        				break;
	        		}
	        		for (int k = size-1; k >= j; k--){
	        			queArray[k+1] = queArray[k];
	        		}
	        		queArray[j] = item;
	        		size++;
	        	}
	        	
	        	public Edge removeMin(){
	        		return queArray[--size];
	        	}
	        	
	        	public void removN(int n){
	        		for(int j = n; j < size-1; j++){
	        			queArray[j] = queArray[j+1];
	        			size--;
	        		}
	        	}
	        	
	        	public Edge peekMin(){
	        		return queArray[size-1];
	        	}
	        	
	            public int size(){
	            	return size;
	            }
	            
	            public boolean isEmpty(){
	            	return (size == 0);
	            }
	        	
	            public Edge peekN(int n ){
	            	return queArray[n];
	            }
	            
	            public int find(int findDex){
	            	for(int j = 0; j < size; j++)
	            		if (queArray[j].desVert == findDex)
	            			return j;
	            	return -1;
	            }
	        }////end class priorityQ
	        
	        class Graphs{
	        	private final int MAX_VERTS = 1000;
	            private final int INFINITY = 1000000;
	            private Vertex vertexList[];
	            private int adjMat[][];
	            private int nVerts;
	            private int currentVert;
	            private PriorityQ thePQ;
	            private int nTree;
	            
	            public Graphs(){
	            	vertexList = new Vertex[MAX_VERTS];
	            	adjMat = new int[MAX_VERTS][MAX_VERTS];
	            	nVerts = 0;
	            	for(int j = 0; j < MAX_VERTS;j++)
	            		for(int k = 0; k < MAX_VERTS;k++)
	            			adjMat[j][k] = INFINITY;
	            	thePQ = new PriorityQ();
	            }
	            public void addVertex(int lab){
	            	vertexList[nVerts++] = new Vertex(lab);
	            }
	            public void addEdge(int start, int end, int weight){
	            	adjMat[start][end] = weight;
	            	adjMat[end][start] = weight;
	            }
	        }
	        public static  void main(String[] args){
	    		Scanner fin = new Scanner (System.in);
	    		int fielNum = fin.nextInt();
	    		int waterNum = fin.nextInt();
	    		Graph graph = new Graph();
	    		for(int i = 1; i <= fielNum; i++ ){
	    //			graph.addVertex(i);  
	    		}
	    		for(int i = 0; i < waterNum; i++){
	    			String[] edgestr = fin.nextLine().split(",");
	    			int[] edge = new int[edgestr.length];
	    			for(int j = 0 ; j< edge.length; j++){
	    				edge[j] =  Integer.parseInt(edgestr[j]);
	    			}
	    		}
	    		   
	    		
	    	}
	        
	}  


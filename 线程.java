package com.juzhen;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class juzhen {
	static int times= 2;//循环次数
	static int len=1200;//矩阵大小
	static int oi;//bian
	
	class threads implements Runnable{

		private int num;
		threads(int i){
			this.num=i;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	
	//对矩阵进行初始化，随即赋值，10~100
	public static void create_matrix(int [][] matrix){
		System.out.println("NEW MATRIX:");
		Random random=new Random();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]=Math.abs(random.nextInt()%90)+10;
				//System.out.print(matrix[i][j]+" ");
			}
			//System.out.println();
		}
	}
	//清零
	public static void to_matrix_zero(int [][] matrix){
		System.out.print("CLEAR MATRIX:");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<len;j++){
				matrix[i][j]=0;
				//System.out.print(matrix[i][j]+" ");
			}
			//System.out.println();
		}
		System.out.println("CLEAR MATRIX OK");
	}
	
	//单线程计算
	public static void single(int [][]a,int [][]b,int [][]c){
		
		for(int val=0;val<times;val++){//循环次数
			for (int i=0;i<a.length;i++){
				for (int j=0;j<a[i].length;j++){
					for(int mul=0;mul<a.length;mul++){
						c[i][j ]+=a[i][mul]*b[j][mul];
					}
				}
			}
		}

	}
	
	//多线程计算
	public void multi(int [][]a,int [][]b,int [][]c){
		
		for(int val=0;val<times;val++){
			for (int i=0;i<a.length;i++){
				//oi=i;
				
				Thread t = new Thread(new threads(i));
				t.start();
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//					new Thread(new Runnable(){    //内部类，runnable方法，调用thread的构造方法
//						@Override
//						public void run() {
//							for (int j=0;j<len;j++){
//								for(int mul=0;mul<a.length;mul++){
//									c[oi][j]+=a[oi][mul]*b[j][mul];
//								}
//							}
//						}
//						
//					}).start();
//				                                                
			}
		}
		

	}
	//线程池
	public static void multi_pool_fixed(int [][]a,int [][]b,int [][]c){
		ExecutorService pool = Executors.newFixedThreadPool(4);//固定个数
		for(int val=0;val<times;val++){
			for (int i=0;i<a.length;i++){
				pool.execute(new Thread(new Runnable(){//执行
					public void run(){
						for (int j=0;j<len;j++){
								for(int mul=0;mul<a.length;mul++){
									c[oi][j]+=a[oi][mul]*b[j][mul];
								}
							}
					}
				}));
			}
		}
		pool.shutdown();//关闭线程池
	while(!pool.isTerminated()){}
	}
	//线程池
	public static void multi_pool_cached(int [][]a,int [][]b,int [][]c){
		ExecutorService pool = Executors.newCachedThreadPool();//固定
		for(int val=0;val<times;val++){
			for (int i=0;i<a.length;i++){
				pool.execute(new Thread(new Runnable(){//执行
					public void run(){
						for (int j=0;j<len;j++){
								for(int mul=0;mul<a.length;mul++){
									c[oi][j]+=a[oi][mul]*b[j][mul];
								}
							}
					}
				}));
			}
		}
		pool.shutdown();//关闭线程池
		while(!pool.isTerminated()){}
	}
	public void exe(){
		
	}
	//main
	public static void main(String[] args){
		juzhen ii = new juzhen();
		
		static int [][] matrix_a=new int [len][len];//A matrix
		static int [][] matrix_b=new int [len][len];//B
		static int [][] matrix_c=new int [len][len];//C
		create_matrix(matrix_a); 
		create_matrix(matrix_b);
		create_matrix(matrix_c);
		
		long startTime=System.currentTimeMillis(); 
		single(matrix_a,matrix_b,matrix_c);
		long endTime=System.currentTimeMillis();
		System.out.println("单线程程序运行时间： "+(endTime-startTime)+"ms");
		//to_matrix_zero(matrix_c);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		long startTimes=System.currentTimeMillis(); 
		ii.multi(matrix_a,matrix_b,matrix_c);
		long endTimes=System.currentTimeMillis();
		System.out.println("多线程程序运行时间： "+(endTimes-startTimes)+"ms");
		//to_matrix_zero(matrix_c);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		long startTimess=System.currentTimeMillis(); 
		multi_pool_fixed(matrix_a,matrix_b,matrix_c);
		long endTimess=System.currentTimeMillis();
		System.out.println("线程池程序运行时间：fixed "+(endTimess-startTimess)+"ms");
		//to_matrix_zero(matrix_c);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		long startTimesss=System.currentTimeMillis(); 
		multi_pool_cached(matrix_a,matrix_b,matrix_c);
		long endTimesss=System.currentTimeMillis();
		System.out.println("线程池程序运行时间：cached "+(endTimesss-startTimesss)+"ms");
	//检查出错	
		int w=0;
		for(int i=0;i<matrix_c.length;i++){
			
			for(int j=0;j<matrix_c[i].length;j++){
				if (matrix_c[i][j]==0){
					//System.out.println("wrong");
					w++;
				}
				//System.out.print(matrix_c[i][j]+" ");
				
			}
			
		}
		System.out.println(w);
	}
}


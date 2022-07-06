/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chinn
 */

import java.util.*;
 
public class SJF {
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.println ("Enter no. of processes:");
int n = sc.nextInt();
int pid[] = new int[n];
int at[] = new int[n]; // at means arrival time
int bt[] = new int[n]; // bt means burst time
int ct[] = new int[n]; // ct means complete time
int ta[] = new int[n]; // ta means turn around time
int wt[] = new int[n];  //wt means waiting time
int f[] = new int[n];  // f means it is flag it checks process is completed or not
int st=0, tot=0;
float avgwt=0, avgta=0;
 
for(int i=0;i<n;i++)
{
    System.out.println ("Enter process " + (i+1) + " Arrival time:");
    at[i] = sc.nextInt();
    System.out.println ("Enter process " + (i+1) + " Brust time:");
    bt[i] = sc.nextInt();
    pid[i] = i+1;
    f[i] = 0;
}
boolean a = true;
while(true)
{
    int c=n, min=999;
if (tot == n) // total no of process = completed process loop will be terminated
break;
for (int i=0; i<n; i++)
{
/*
* If i'th process arrival time <= system time and its flag=0 and burst<min
* That process will be executed first
*/
if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
{
    min=bt[i];
    c=i;
}
}
/* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
if (c==n)
    st++;
else
{
    ct[c]=st+bt[c];
    st+=bt[c];
    ta[c]=ct[c]-at[c];
    wt[c]=ta[c]-bt[c];
    f[c]=1;
    tot++;
}
}
    System.out.println("\nProcesses ||" + " Arrival Time ||" + " Burst Time ||" + " Completion Time ||" + " Turn-Around Time ||" + " Waiting Time ");
    for(int i=0;i<n;i++)
{
    avgwt+= wt[i];
    avgta+= ta[i];
    System.out.println(pid[i]+"\t || \t"+at[i]+"\t || \t"+bt[i]+"\t || \t"+ct[i]+"\t || \t"+ta[i]+"\t || \t"+wt[i]);
}
    System.out.println ("\nAverage TurnaroundTime is "+ (float)(avgta/n));
    System.out.println ("Average WaitingTime is "+ (float)(avgwt/n));
    sc.close();
}
}

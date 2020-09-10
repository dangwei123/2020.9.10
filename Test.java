给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        back(candidates,target,new ArrayList<>(),0,new boolean[candidates.length]);
        return res;
    }
    private void back(int[] candidates,int target,List<Integer> row,int index,boolean[] v){

         if(target==0){
            res.add(new ArrayList(row));
            return;
        }
        
        if(index==candidates.length||target<0){
            return ;
        }

       

        for(int i=index;i<candidates.length;i++){
            if(i!=0&&candidates[i]==candidates[i-1]&&!v[i-1]){
                continue;
            }
            target-=candidates[i];
            row.add(candidates[i]);
            v[i]=true;

            back(candidates,target,row,i+1,v);

            target+=candidates[i];
            row.remove(row.size()-1);
            v[i]=false;
        }
    }
}
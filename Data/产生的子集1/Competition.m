%% Get the weight between product_review and star_ratings
score_mat = [1,3;1/3,1]     
% Normalization processing
[a,b] = size(score_mat)
sum_score_mat = sum(score_mat,1)   
sum_col = repmat(sum_score_mat,a,1)
weight = score_mat ./ sum_col   
% Get the weight
weight = weight(:,1)    

%% Get the weight between four different types of customers by eigenvalue method
customer_type_mat = [1,0.3333,3;3,1,7;0.3333,0.1429,1]
[V,D] = eig(customer_type_mat)
Max_eig = max(max(D))
% Determine whether the judgment matrix satisfies consistency
[m,n] = size(customer_type_mat)
CI = (Max_eig - n) / (n-1);
RI = [0,0,0.52,0.89,1.12,1.26,1.36,1.41,1.46,1.49,1.52,1.54,1.56,1.58,1.59]    
CR = CI/RI(n);
disp('CI=');disp(CI);
disp('CR=');disp(CR);
if CR < 0.10
    disp('We can accept the consistency of the matrix because CR < 0.1')
else
    disp('We can not accept the consistency of the matrix because CR > 0.1')
end

D == Max_eig      
[row,col] = find(D == Max_eig,1)
V_col = V(:,col)    
sum_V_col = sum(V_col)
disp('Weight£º');
disp( V_col ./ sum_V_col )

%% Get the weight between satisfaction and reference value
sat_ref_mat = [1,3;1/3,1]
% Normalization processing
[a,b] = size(sat_ref_mat)
sum_sat_ref_mat = sum(sat_ref_mat,1)
sum_col = repmat(sum_sat_ref_mat,a,1)
weight_sat = sat_ref_mat ./ sum_col 
% Get the weight
weight_sat = weight_sat(:,1) 
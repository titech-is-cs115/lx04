-- [0..9]^4の直積集合を作る
prod :: Int -> Int -> [[Int]]
prod x y = sequence $ replicate x [0..y]

count0 :: Int -> [Int] -> Int
count0 _ [] = 0
count0 n (x:xs) =
  if n == x then 1 + count0 n xs
  else count0 n xs

count1 :: [Int] -> [Int]
count1　lst = [a+2, b+1, c+2, others]
              where a = count0 1 lst
                    b = count0 2 lst
                    c = count0 3 lst
                    others = (length lst) - (a + b + c)

constraint :: [Int] -> Bool
constraint lst = lst == count1 lst

check0 :: [[Int]] -> [[Int]]
check0 [] = []
check0 (x:xs) =
  if constraint x == True then x : check0 xs
  else check0 xs

main = putStrLn $ unwords $ map show $ check0 candidates
       where candidates = prod 4 9

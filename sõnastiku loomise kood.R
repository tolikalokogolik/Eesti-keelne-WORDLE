file = file("C:/Users/Natal/Downloads/sonastik.txt", open="r", blocking = TRUE)

read <-c()
repeat{
  pl = readLines(file, n = 1, encoding= "UTF-8") # Read one line from the connection.
  if(identical(pl, character(0))){break} # If the line is empty, exit.
  read <-c(read, pl) # Otherwise, print and repeat next iteration.
}

read

library(stringr)
library(dplyr)
sonad <-c()

for (i in 1:length(read)){
  sonad <- c(sonad, str_split(read[i], "\t")[[1]][2])
}


uued_sonad <- c()
for (i in 1:length(sonad)){
  uued_sonad <- c(uued_sonad, str_split(gsub(",", "", sonad[i]), " ")[[1]])
}

andmestik <- data.frame(sona = uued_sonad)
andmestik

andmestik <- andmestik %>% 
  filter(nchar(sona)>=4, nchar(sona)<=6) %>% 
  filter(!grepl("\\("  ,sona) ) %>% 
  filter(!grepl("\\)"  ,sona) ) %>% 
  filter(!grepl("\\."  ,sona) ) %>% 
  filter(!grepl("-"  ,sona) ) %>% 
  mutate(sona = tolower(sona)) %>% 
  distinct()

write.table(andmestik %>% filter(nchar(sona)==4), "C:/Users/Natal/Downloads/dic4.txt")

write.table(andmestik %>% filter(nchar(sona)==5), "C:/Users/Natal/Downloads/dic5.txt")

write.table(andmestik %>% filter(nchar(sona)==6), "C:/Users/Natal/Downloads/dic6.txt")

andmestik %>% 
  filter(nchar(sona)>=4, nchar(sona)<=6) %>% 
  filter(!grepl("a"  ,sona) )

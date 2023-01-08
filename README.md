## Architecture 🏰

- MVVM
- Multi-Module
- Clean Architecture

## Tech Stack

- Compose
- Coroutine
- Paging3
- Hilt

## Package Structure

```java
app
├── ...
├── src
│   ├── app //Application            
│   │                  
presentation
├── ...
├── src
│   ├── presentation 
│   │   ├── theme  //App Theme 정의       
│   │   ├── main   //홈 화면                
│   │   ├── detail //상세 화면 
│   │   │ 
data                                       
├── ...                                     
├── src               
│   ├── data                              
│   │   ├── api //API interface 정의
│   │   ├── di //Dependency Injection Module
│   |   ├── broad // broad enpoint 
│   │   │   ├── datasource                
│   │   │   ├── dto  
│   │   │   ├── mapper                  
│   │   │   ├── paging      
│   │   │   ├── repository
domain                                    
├── ...                                 
├── src                                         
│   ├── domain                                  
│   │   ├── model              
│   │   ├── repository  
│   │   ├── usecase                  
│   │   │                
core
├── ...
├── src
│   ├── core
│   │   ├── android               
│   │   ├── kotlin  
│   │   ├── base                  
│   │   ├── compose      
```

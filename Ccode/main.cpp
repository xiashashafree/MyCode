
//main.cpp
void menu()
{
	printf("***********1.play************\n");
	printf("***********0.exit************\n");
}
void game()
{
	int ret = 0;
	char board[3][3];
	InitBoard(board, ROW, COL);
	//打印棋盘    
	ShowBoard(board,ROW,COL); 
	while (1)
	{
		PlayerMove(board, ROW, COL);        
		//每次都要判断是否赢了比赛       
		ret = IsWin(board,ROW,COL);        
		if(ret != ' ')        
		{            break;        }       
		ShowBoard(board,ROW,COL);        
		ComputerMove(board,ROW,COL);        
		if(ret != ' ')        
		{            break;        }        
		ShowBoard(board,ROW,COL);    
	} 
	if (ret == 'X')    
	{ printf("玩家获胜\n"); }
	else if (ret == 'O')    
	{ printf("电脑获胜\n"); }
	else if (ret == 'F')    
	{ printf("平局\n"); }

	

}
int main()
{
	srand((unsigned int)time(NULL));
	printf("欢迎来到三子棋\n");
	int input = 0;
	do
	{
		menu();
		printf("请输入你的操作\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			printf("开始游戏\n");
			game();
			break;
		case 0:
			printf("退出游戏\n");
			break;
		default:
			printf("请输入正确的数字\n");
			break;
		}
	} while (input);
	return 0;
}


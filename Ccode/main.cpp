
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
	//��ӡ����    
	ShowBoard(board,ROW,COL); 
	while (1)
	{
		PlayerMove(board, ROW, COL);        
		//ÿ�ζ�Ҫ�ж��Ƿ�Ӯ�˱���       
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
	{ printf("��һ�ʤ\n"); }
	else if (ret == 'O')    
	{ printf("���Ի�ʤ\n"); }
	else if (ret == 'F')    
	{ printf("ƽ��\n"); }

	

}
int main()
{
	srand((unsigned int)time(NULL));
	printf("��ӭ����������\n");
	int input = 0;
	do
	{
		menu();
		printf("��������Ĳ���\n");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			printf("��ʼ��Ϸ\n");
			game();
			break;
		case 0:
			printf("�˳���Ϸ\n");
			break;
		default:
			printf("��������ȷ������\n");
			break;
		}
	} while (input);
	return 0;
}


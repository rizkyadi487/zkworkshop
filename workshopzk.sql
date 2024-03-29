USE [workshopzk]
GO
/****** Object:  Table [dbo].[m_customer]    Script Date: 03/09/2018 21:44:26 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[m_customer](
	[cust_id] [int] NOT NULL,
	[cust_name] [varchar](50) NOT NULL,
	[cust_address] [varchar](50) NOT NULL,
 CONSTRAINT [PK_m_customer] PRIMARY KEY CLUSTERED 
(
	[cust_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[m_product]    Script Date: 03/09/2018 21:44:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[m_product](
	[prod_id] [varchar](50) NOT NULL,
	[prod_name] [varchar](50) NOT NULL,
	[prod_price] [int] NOT NULL,
	[exp_date] [date] NOT NULL,
 CONSTRAINT [PK_m_product] PRIMARY KEY CLUSTERED 
(
	[prod_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_order]    Script Date: 03/09/2018 21:44:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_order](
	[order_id] [varchar](50) NOT NULL,
	[cust_id] [int] NOT NULL,
	[total] [int] NOT NULL,
 CONSTRAINT [PK_t_order] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[t_order_detail]    Script Date: 03/09/2018 21:44:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[t_order_detail](
	[order_id] [varchar](50) NOT NULL,
	[prod_id] [varchar](50) NOT NULL,
	[prod_price] [int] NULL,
	[prod_qty] [int] NULL,
	[sub_total] [int] NULL,
 CONSTRAINT [PK_t_order_detail] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC,
	[prod_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[m_customer] ([cust_id], [cust_name], [cust_address]) VALUES (1, N'cust 1', N'Jakarta')
INSERT [dbo].[m_customer] ([cust_id], [cust_name], [cust_address]) VALUES (2, N'cust 2', N'bandung')
INSERT [dbo].[m_product] ([prod_id], [prod_name], [prod_price], [exp_date]) VALUES (N'P01', N'prod 1', 1000, CAST(0x0F3F0B00 AS Date))
INSERT [dbo].[m_product] ([prod_id], [prod_name], [prod_price], [exp_date]) VALUES (N'P02', N'prod 2', 2000, CAST(0x103F0B00 AS Date))

   #使用SimpleCursorAdapter
  ＃基本的SQL语句
  ＃如果不卸载apk，调试的时候很容易出错

      SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MainActivity.this,
                R.layout.layout_list,
                cursor,
                new String[]{"news_title","news_content"},
                new int[]{R.id.item_title,R.id.item_content},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

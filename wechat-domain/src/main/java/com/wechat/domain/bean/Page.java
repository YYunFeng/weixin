package com.wechat.domain.bean;

/**
 * Created with IntelliJ IDEA.
 * User: YUNFENG
 * Date: 13-5-27
 * Time: ����6:22
 * To change this template use File | Settings | File Templates.
 */
public class Page {
    private int totalRow;	//�ܹ���¼��
    private int totalPage;	//�ܹ�ҳ��
    private int currentPage = 1; //��ǰҳ��Ĭ��Ϊ1
    private int pageSize = 20;   //ҳ�Ĵ�С
    private boolean hasPrevious; //�Ƿ�����һҳ
    private boolean hasNext; //�Ƿ�����һҳ
    private boolean bof;  //�Ƿ�����ҳ
    private boolean eof;  //�Ƿ���βҳ

    public int getTotalRow() {
        return totalRow;
    }
    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalPage() {
        return totalPage;
    }
    public int getCurrentPage() {

        return this.currentPage;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }
    public boolean isHasNext() {
        return hasNext;
    }
    public boolean isBof() {
        return bof;
    }
    public boolean isEof() {
        return eof;
    }
    public boolean hasNext() {
        return currentPage < this.totalPage;
    }
    public boolean hasPrevious() {
        return currentPage > 1;
    }
    public boolean isFirst() {
        return currentPage == 1;
    }
    public boolean isLast() {
        return currentPage >= this.totalPage;
    }

    // ��ȡ��ҳ��С
    public int getPageSize() {
        return pageSize;
    }
    // ���÷�ҳ��С
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /*
     * ���췽��
     */
    public Page(){

    }



    /*
     * ���췽��
       @param totalRow �ܼ�¼��
       @param pageSize ҳ�Ĵ�С
       @param page ҳ��
     */
    public Page(int totalRow, int pageSize, int page) {
        this.totalRow = totalRow;
        this.pageSize = pageSize;
        // ����ҳ��С���ܼ�¼���������ҳ��
        this.totalPage = countTotalPage(this.pageSize, this.totalRow);
        // ������ǰҳ
        setCurrentPage(page);
        init();
    }

    // ��ʼ����Ϣ
    private void init() {

        this.hasNext = hasNext();

        this.hasPrevious = hasPrevious();

        this.bof = isFirst();

        this.eof = isLast();

    }

    // �������㵱ǰҳ
    public void setCurrentPage(int currentPage) {
        if(currentPage>this.totalPage){
            this.currentPage=this.totalPage;
        }else if (currentPage<1){
            this.currentPage=1;
        }
        else{
            this.currentPage=currentPage;
        }
    }

    // ��ȡ��ǰҳ��¼�Ŀ�ʼ����
    public int getBeginIndex() {
        int beginIndex = (currentPage - 1) * pageSize; // �����±��0��ʼ
        return beginIndex;
    }

    // ������ҳ��
    public int countTotalPage(int pageSize, int totalRow) {
        int totalPage = totalRow % pageSize == 0 ? totalRow / pageSize : totalRow / pageSize + 1;
        return totalPage;
    }

    // ������һҳ��ҳ��
    public int getNextPage() {
        if (currentPage + 1 >= this.totalPage) { // �����ǰҳ�Ѿ������ҳ �򷵻����ҳ
            return this.totalPage;
        }
        return currentPage + 1;
    }


    // ����ǰһҳ��ҳ��
    public int getPreviousPage() {
        if (currentPage - 1 <= 1) {
            return 1;
        } else {
            return currentPage - 1;
        }
    }
}

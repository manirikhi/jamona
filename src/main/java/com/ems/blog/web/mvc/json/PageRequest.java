package com.ems.blog.web.mvc.json;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageRequest implements Pageable {

    private static Integer LIMIT_MAX = 50;

    private Integer page;
    private Integer limit = LIMIT_MAX;
    private Integer start;
    private String dir = "DESC";
    private String field;

    public void setPage(final int page) {
        this.page = page;
    }

    public void setLimit(final int limit) {
        if (limit > LIMIT_MAX) {
            this.limit = LIMIT_MAX;
        } else {
            this.limit = limit;
        }
    }

    public void setStart(final int start) {
        this.start = start;
    }

    public void setDir(final String dir) {
        this.dir = dir;
    }

    public void setField(final String field) {
        this.field = field;
    }

	public int getPageNumber() {
		return page;
	}

	public int getPageSize() {
		return limit;
	}

	public int getOffset() {
		return start;
	}

	public Sort getSort() {
		if (this.field != null) {
            return new Sort(Sort.Direction.valueOf(this.dir), this.field);
        }
        return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageRequest [page=" + page + ", limit=" + limit + ", start="
				+ start + ", dir=" + dir + ", field=" + field + "]";
	}

	public Pageable first() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	public Pageable next() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pageable previousOrFirst() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

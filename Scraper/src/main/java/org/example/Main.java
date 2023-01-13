package org.example;

public class Main {

    public static void main(String[] args) {
        int nPages = 2;
        String urlWithoutOffset = "https://www.booking.com/searchresults.es.html?ss=Madrid&ssne=Madrid&ssne_untouched" +
                "=Madrid&label=es-JCB2UqznXtCO_RDP_nj5CAS410545262609%3Apl%3Ata%3Ap1%3Ap22.563.000%3Aac%3Aap%3Aneg%3" +
                "Afi%3Atikwd-65526620%3Alp1005463%3Ali%3Adec%3Adm%3Appccp%3DUmFuZG9tSVYkc2RlIyh9Ye8F2ouj63ytkBtrYs5TA" +
                "fs&aid=376371&lang=es&sb=1&src_elem=sb&src=index&dest_id=-390625&dest_type=city&group_adults=2&no_ro" +
                "oms=1&group_children=0&sb_travel_purpose=leisure&offset=";

        Controller controller = new Controller();
        controller.run(nPages, urlWithoutOffset);
    }
}

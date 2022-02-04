package io.runon.cryptocurrency.exchanges.ftx;

import com.seomse.crawling.core.http.HttpUrl;
import io.runon.cryptocurrency.trading.MarketSymbol;

/**
 * ftx 거래소
 * https://docs.ftx.com/#websocket-api
 * @author macle
 */
public class FtxExchange {

    public static String getTickers(){
        return HttpUrl.get("https://ftx.com/api/markets");
    }

    public static MarketSymbol getMarketSymbol(String cryptocurrencyId) {
        MarketSymbol marketSymbol = new MarketSymbol();
        cryptocurrencyId = cryptocurrencyId.toUpperCase();

        int index = cryptocurrencyId.indexOf("/");
        if(index == -1){
            index = cryptocurrencyId.indexOf("-");
        }

        marketSymbol.setSymbol(cryptocurrencyId.substring(0, index));
        marketSymbol.setMarket(cryptocurrencyId.substring(index + 1));

        return marketSymbol;
    }
}
